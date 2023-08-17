package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.request.TourRequestDTO;
import com.ptithcm.tour.dto.response.MessageResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.dto.response.TourResponseDTO;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.TourMapper;
import com.ptithcm.tour.model.LoaiTour;
import com.ptithcm.tour.model.Tour;
import com.ptithcm.tour.repository.LoaiTourRepository;
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
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private LoaiTourRepository loaiTourRepository;

    @Autowired
    private TourMapper tourMapper;

    @Override
    public PageDataDTO<TourResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO) {
        Pageable pagingSort = PageRequest.of(pageLinkDTO.getPage(), pageLinkDTO.getSize(), Sort.by(pageLinkDTO.getSort()));
        Page<Tour> tourPage = tourRepository.getAllPaginationWithCondition(pageLinkDTO.getSearchText(), pagingSort);
        return new PageDataDTO<>(
                tourPage.getContent().stream().map(tour -> tourMapper.toResponseDTO(tour)).collect(Collectors.toList()),
                tourPage.getTotalPages(),
                tourPage.getTotalElements(),
                tourPage.hasNext()
        );
    }

    @Override
    public List<TourResponseDTO> getAllWithCondition(LinkDTO linkDTO) {
        return tourRepository.getAllWithCondition(linkDTO.getSearchText(), Sort.by(linkDTO.getSort()))
                .stream()
                .map(tour -> tourMapper.toResponseDTO(tour))
                .collect(Collectors.toList());
    }

    @Override
    public TourResponseDTO save(TourRequestDTO tourRequestDTO) {
        Long id = tourRequestDTO.getMaTour();
        Tour tour = new Tour();
        if (id != null) {
            tour = tourRepository.findById(id).orElseThrow(
                    () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Tour", "Mã tour", id))
            );
        }
        LoaiTour loaiTour = loaiTourRepository.findById(tourRequestDTO.getMaLoaiTour()).orElseThrow(
                () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tour", "Mã loại tour", tourRequestDTO.getMaLoaiTour()))
        );
        BeanUtils.copyProperties(tourRequestDTO, tour, "maLoaiTour");
        tour.setLoaiTour(loaiTour);
        tour = tourRepository.save(tour);
        return tourMapper.toResponseDTO(tour);
    }

    @Override
    public TourResponseDTO getById(Long id) {
        return tourMapper.toResponseDTO(
                tourRepository.findById(id).orElseThrow(
                        () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Tour", "Mã tour", id))
                )
        );
    }

    @Override
    public MessageResponseDTO deleteTour(Long id) {
        tourRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy Tour có mã Tour là %s", id)));
        tourRepository.deleteById(id);
        return new MessageResponseDTO(200, "Xóa Tour thành công");
    }
}
