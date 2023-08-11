package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.ThamGiaTourResponseDTO;
import com.ptithcm.tour.model.ThamGiaTour;

public interface ThamGiaTourMapper {
    ThamGiaTourResponseDTO toResponseDTO(ThamGiaTour entity);
}
