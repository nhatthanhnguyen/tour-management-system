package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.TourResponseDTO;
import com.ptithcm.tour.model.Tour;

public interface TourMapper {
    TourResponseDTO toResponseDTO(Tour entity);
}
