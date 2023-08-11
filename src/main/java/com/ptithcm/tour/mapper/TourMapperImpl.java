package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.TourResponseDTO;
import com.ptithcm.tour.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourMapperImpl implements TourMapper {
    @Autowired
    private LoaiTourMapper loaiTourMapper;

    @Override
    public TourResponseDTO toResponseDTO(Tour entity) {
        return TourResponseDTO.builder()
                .maTour(entity.getId())
                .gia(entity.getGia())
                .loaiTour(loaiTourMapper.toResponseDTO(entity.getLoaiTour()))
                .image(entity.getImage())
                .moTa(entity.getMoTa())
                .ngayBatDau(entity.getNgayBatDau())
                .diemDen(entity.getDiemDen())
                .diemDi(entity.getDiemDi())
                .trangThai(entity.getTrangThai())
                .build();
    }
}
