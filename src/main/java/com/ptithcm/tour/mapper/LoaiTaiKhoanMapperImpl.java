package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.LoaiTaiKhoanResponseDTO;
import com.ptithcm.tour.model.LoaiTaiKhoan;
import org.springframework.stereotype.Component;

@Component
public class LoaiTaiKhoanMapperImpl implements LoaiTaiKhoanMapper {
    @Override
    public LoaiTaiKhoanResponseDTO toResponseDTO(LoaiTaiKhoan entity) {
        return LoaiTaiKhoanResponseDTO.builder()
                .maLoaiTK(entity.getId())
                .tenLoaiTK(entity.getTenLoaiTK())
                .ghiChu(entity.getGhiChu()).build();
    }
}
