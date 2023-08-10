package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.LoaiTourRequestDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LoaiTourResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.LoaiTourMapper;
import com.ptithcm.tour.model.LoaiTour;
import com.ptithcm.tour.repository.LoaiTourRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_RESPONSE;

@Service
public class LoaiTourServiceImpl implements LoaiTourService {
    @Autowired
    private LoaiTourRepository loaiTourRepository;

    @Autowired
    private LoaiTourMapper loaiTourMapper;

    @Override
    public LoaiTourResponseDTO getById(Long id) {
        return loaiTourMapper.toResponseDTO(
                loaiTourRepository.findById(id).orElseThrow(
                        () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tour", "Mã loại tour", id))
                )
        );
    }

    @Override
    public LoaiTourResponseDTO save(LoaiTourRequestDTO loaiTourRequestDTO) {
        LoaiTour loaiTour = new LoaiTour();
        Long id = loaiTourRequestDTO.getMaLoaiTour();
        if (id != null) {
            loaiTour = loaiTourRepository.findById(id).orElseThrow(
                    () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tour", "Mã loại tour", id))
            );
        }
        BeanUtils.copyProperties(loaiTourRequestDTO, loaiTour, "id");
        loaiTour = loaiTourRepository.save(loaiTour);
        return loaiTourMapper.toResponseDTO(loaiTour);
    }

    @Override
    public PageDataDTO<LoaiTourResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO) {
        Pageable pagingSort = PageRequest.of(pageLinkDTO.getPage(), pageLinkDTO.getSize(), Sort.by(pageLinkDTO.getSort()));
        Page<LoaiTour> loaiTourPage = loaiTourRepository.getAllPaginationWithCondition(pageLinkDTO.getSearchText(), pagingSort);
        return new PageDataDTO<>(
                loaiTourPage.getContent().stream().map(loaiTour -> loaiTourMapper.toResponseDTO(loaiTour)).collect(Collectors.toList()),
                loaiTourPage.getTotalPages(),
                loaiTourPage.getTotalElements(),
                loaiTourPage.hasNext()
        );
    }

    @Override
    public List<LoaiTourResponseDTO> getAllWithCondition(LinkDTO linkDTO) {
        return loaiTourRepository.getAllWithCondition(linkDTO.getSearchText(), Sort.by(linkDTO.getSort()))
                .stream()
                .map(loaiTour -> loaiTourMapper.toResponseDTO(loaiTour))
                .collect(Collectors.toList());
    }
}
