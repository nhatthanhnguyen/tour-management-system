package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.model.TaiKhoan;

public interface TaiKhoanMapper {
    TaiKhoanResponseDTO toResponseDTO(TaiKhoan entity);
}
