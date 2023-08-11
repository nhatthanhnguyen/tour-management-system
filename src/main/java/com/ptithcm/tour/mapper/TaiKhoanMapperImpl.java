package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.dto.response.TaiKhoanSecureResponseDTO;
import com.ptithcm.tour.model.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaiKhoanMapperImpl implements TaiKhoanMapper {
    @Autowired
    private LoaiTaiKhoanMapper loaiTaiKhoanMapper;

    @Override
    public TaiKhoanResponseDTO toResponseDTO(TaiKhoan entity) {
        return TaiKhoanResponseDTO.builder()
                .maTaiKhoan(entity.getId())
                .ho(entity.getHo())
                .ten(entity.getTen())
                .sdt(entity.getSdt())
                .phai(entity.getPhai())
                .ngaySinh(entity.getNgaySinh())
                .loaiTaiKhoan(loaiTaiKhoanMapper
                        .toResponseDTO(entity.getLoaiTaiKhoan())
                ).build();
    }

    @Override
    public TaiKhoanSecureResponseDTO toSecureResponseDTO(TaiKhoan entity) {
        return TaiKhoanSecureResponseDTO.builder()
                .ho(entity.getHo())
                .ten(entity.getTen())
                .phai(entity.getPhai())
                .ngaySinh(entity.getNgaySinh())
                .build();
    }
}
