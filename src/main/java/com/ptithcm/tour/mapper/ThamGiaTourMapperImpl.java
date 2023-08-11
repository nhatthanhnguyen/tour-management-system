package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.ThamGiaTourResponseDTO;
import com.ptithcm.tour.model.ThamGiaTour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThamGiaTourMapperImpl implements ThamGiaTourMapper {
    @Autowired
    private TaiKhoanMapper taiKhoanMapper;

    @Autowired
    private TourMapper tourMapper;

    @Override
    public ThamGiaTourResponseDTO toResponseDTO(ThamGiaTour entity) {
        return ThamGiaTourResponseDTO.builder()
                .sttThamGia(entity.getId())
                .viTri(entity.getViTri())
                .ghiChu(entity.getGhiChu())
                .checkin(entity.getCheckin())
                .diaDiemDon(entity.getDiaDiemDon())
                .taiKhoan(taiKhoanMapper.toSecureResponseDTO(entity.getTaiKhoan()))
                .tour(tourMapper.toResponseDTO(entity.getTour()))
                .build();
    }
}
