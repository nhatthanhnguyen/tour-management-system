package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.LoaiTaiKhoanResponseDTO;
import com.ptithcm.tour.model.LoaiTaiKhoan;

public interface LoaiTaiKhoanMapper {
    LoaiTaiKhoanResponseDTO toResponseDTO(LoaiTaiKhoan entity);
}
