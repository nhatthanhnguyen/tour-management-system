package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.LichTrinhResponseDTO;
import com.ptithcm.tour.model.LichTrinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LichTrinhMapperImpl implements LichTrinhMapper {
    @Autowired
    private DiaDiemMapper diaDiemMapper;

    @Autowired
    private TourMapper tourMapper;
    @Override
    public LichTrinhResponseDTO toResponseDTO(LichTrinh entity) {
        return LichTrinhResponseDTO.builder()
                .sttLichTrinh(entity.getId())
                .noiDungLichTrinh(entity.getNoiDungLichTrinh())
                .thoiGianBatDau(entity.getThoiGianBatDau())
                .diaDiem(diaDiemMapper.toResponseDTO(entity.getDiaDiem()))
                .tour(tourMapper.toResponseDTO(entity.getTour()))
                .build();
    }
}
