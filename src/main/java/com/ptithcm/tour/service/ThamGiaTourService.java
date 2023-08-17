package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.ThamGiaTourRequestDTO;
import com.ptithcm.tour.dto.response.MessageResponseDTO;
import com.ptithcm.tour.dto.response.ThamGiaTourResponseDTO;

import java.util.List;

public interface ThamGiaTourService {
    ThamGiaTourResponseDTO save(ThamGiaTourRequestDTO thamGiaTourRequestDTO);

    List<ThamGiaTourResponseDTO> getThamGiaTourByTour(Long maTour);

    List<ThamGiaTourResponseDTO> getThamGiaTourByUser();

    MessageResponseDTO deleteThamGiaTourById(Long sttThamGia);
}
