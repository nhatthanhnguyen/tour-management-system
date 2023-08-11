package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.PhanHoiRequestDTO;
import com.ptithcm.tour.dto.response.PhanHoiResponseDTO;

import java.util.List;

public interface PhanHoiService {
    PhanHoiResponseDTO save(PhanHoiRequestDTO phanHoiRequestDTO);

    List<PhanHoiResponseDTO> getPhanHoiByCurrentUser();

    List<PhanHoiResponseDTO> getPhanHoiByTour(Long maTour);
}
