package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.DiaDiemRequestDTO;
import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.response.DiaDiemResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.DiaDiemMapper;
import com.ptithcm.tour.model.DiaDiem;
import com.ptithcm.tour.repository.DiaDiemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_BY_ID_RESPONSE;

@Service
public class DiaDiemServiceImpl implements DiaDiemService {
    @Autowired
    private DiaDiemRepository diaDiemRepository;

    @Autowired
    private DiaDiemMapper diaDiemMapper;

    @Override
    public List<DiaDiemResponseDTO> getAllWithCondition(LinkDTO linkDTO) {
        return diaDiemRepository.getAllWithCondition(linkDTO.getSearchText(), Sort.by(linkDTO.getSort()))
                .stream()
                .map(diaDiem -> diaDiemMapper.toResponseDTO(diaDiem))
                .collect(Collectors.toList());
    }

    @Override
    public PageDataDTO<DiaDiemResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO) {
        Pageable pagingSort = PageRequest.of(pageLinkDTO.getPage(), pageLinkDTO.getSize(), Sort.by(pageLinkDTO.getSort()));
        Page<DiaDiem> diaDiemPage = diaDiemRepository.getAllPaginationWithCondition(pageLinkDTO.getSearchText(), pagingSort);
        return new PageDataDTO<>(
                diaDiemPage.getContent().stream().map(diaDiem -> diaDiemMapper.toResponseDTO(diaDiem)).collect(Collectors.toList()),
                diaDiemPage.getTotalPages(),
                diaDiemPage.getTotalElements(),
                diaDiemPage.hasNext()
        );
    }

    @Override
    public DiaDiemResponseDTO getById(Long id) {
        return diaDiemMapper.toResponseDTO(
                diaDiemRepository.findById(id).orElseThrow(
                        () -> new NotFoundException(String.format(NOT_FOUND_BY_ID_RESPONSE, "Địa điểm", "Mã địa điểm", id))
                )
        );
    }

    @Override
    public DiaDiemResponseDTO save(DiaDiemRequestDTO diaDiemRequestDTO) {
        DiaDiem diaDiem = new DiaDiem();
        Long id = diaDiemRequestDTO.getMaDiaDiem();
        if (id != null) {
            diaDiem = diaDiemRepository.findById(diaDiemRequestDTO.getMaDiaDiem())
                    .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_BY_ID_RESPONSE, "Địa điểm", "Mã địa điểm", id)));
        }
        BeanUtils.copyProperties(diaDiemRequestDTO, diaDiem, "id");
        diaDiem = diaDiemRepository.save(diaDiem);
        return diaDiemMapper.toResponseDTO(diaDiem);
    }
}
