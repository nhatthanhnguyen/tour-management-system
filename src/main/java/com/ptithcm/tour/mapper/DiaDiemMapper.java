package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.DiaDiemResponseDTO;
import com.ptithcm.tour.model.DiaDiem;

public interface DiaDiemMapper {
    DiaDiemResponseDTO toResponseDTO(DiaDiem entity);
}
