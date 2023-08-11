package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LichTrinhRequestDTO;
import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LichTrinhResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.LichTrinhMapper;
import com.ptithcm.tour.model.DiaDiem;
import com.ptithcm.tour.model.LichTrinh;
import com.ptithcm.tour.model.Tour;
import com.ptithcm.tour.repository.DiaDiemRepository;
import com.ptithcm.tour.repository.LichTrinhRepository;
import com.ptithcm.tour.repository.TourRepository;
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
public class LichTrinhServiceImpl implements LichTrinhService {
    @Autowired
    private LichTrinhRepository lichTrinhRepository;

    @Autowired
    private DiaDiemRepository diaDiemRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private LichTrinhMapper lichTrinhMapper;

    @Override
    public PageDataDTO<LichTrinhResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO) {
        Pageable pagingSort = PageRequest.of(pageLinkDTO.getPage(), pageLinkDTO.getSize(), Sort.by(pageLinkDTO.getSort()));
        Page<LichTrinh> lichTrinhPage = lichTrinhRepository.getAllPaginationWithCondition(pageLinkDTO.getSearchText(), pagingSort);
        return new PageDataDTO<>(
                lichTrinhPage.getContent().stream().map(lichTrinh -> lichTrinhMapper.toResponseDTO(lichTrinh)).collect(Collectors.toList()),
                lichTrinhPage.getTotalPages(),
                lichTrinhPage.getTotalElements(),
                lichTrinhPage.hasNext()
        );
    }

    @Override
    public List<LichTrinhResponseDTO> getAllWithCondition(LinkDTO linkDTO) {
        return lichTrinhRepository.getAllWithCondition(linkDTO.getSearchText(), Sort.by(linkDTO.getSort()))
                .stream()
                .map(lichTrinh -> lichTrinhMapper.toResponseDTO(lichTrinh))
                .collect(Collectors.toList());
    }

    @Override
    public LichTrinhResponseDTO save(LichTrinhRequestDTO lichTrinhRequestDTO) {
        Long id = lichTrinhRequestDTO.getId();
        LichTrinh lichTrinh = new LichTrinh();
        if (id != null) {
            lichTrinh = lichTrinhRepository.findById(id).orElseThrow(
                    () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Lịch trình", "Mã lịch trình", id))
            );
        }
        DiaDiem diaDiem = diaDiemRepository.findById(lichTrinhRequestDTO.getMaDiaDiem()).orElseThrow(
                () -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Địa điểm",
                        "Mã địa điểm",
                        lichTrinhRequestDTO.getMaDiaDiem())
                )
        );
        Tour tour = tourRepository.findById(lichTrinhRequestDTO.getMaTour()).orElseThrow(
                () -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tour",
                        "Mã tour",
                        lichTrinhRequestDTO.getMaTour())
                )
        );

        BeanUtils.copyProperties(lichTrinhRequestDTO, lichTrinh, "maDiaDiem", "maTour");
        lichTrinh.setDiaDiem(diaDiem);
        lichTrinh.setTour(tour);
        lichTrinh = lichTrinhRepository.save(lichTrinh);
        return lichTrinhMapper.toResponseDTO(lichTrinh);
    }

    @Override
    public LichTrinhResponseDTO getById(Long id) {
        return lichTrinhMapper.toResponseDTO(
                lichTrinhRepository.findById(id).orElseThrow(
                        () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Lịch trình", "Mã lịch trình", id))
                )
        );
    }
}
