package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.PhanHoiResponseDTO;
import com.ptithcm.tour.model.PhanHoi;

public interface PhanHoiMapper {
    PhanHoiResponseDTO toResponseDTO(PhanHoi entity);
}
