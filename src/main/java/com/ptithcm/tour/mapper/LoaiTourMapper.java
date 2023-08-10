package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.LoaiTourResponseDTO;
import com.ptithcm.tour.model.LoaiTour;

public interface LoaiTourMapper {
    LoaiTourResponseDTO toResponseDTO(LoaiTour entity);
}
