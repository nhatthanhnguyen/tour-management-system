package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.LichTrinhResponseDTO;
import com.ptithcm.tour.model.LichTrinh;

public interface LichTrinhMapper {
    LichTrinhResponseDTO toResponseDTO(LichTrinh entity);
}
