package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.LoaiTourResponseDTO;
import com.ptithcm.tour.model.LoaiTour;
import org.springframework.stereotype.Component;

@Component
public class LoaiTourMapperImpl implements LoaiTourMapper {
    @Override
    public LoaiTourResponseDTO toResponseDTO(LoaiTour entity) {
        return LoaiTourResponseDTO.builder()
                .maLoaiTour(entity.getId())
                .tenLoaiTour(entity.getTenLoaiTour())
                .moTa(entity.getMoTa())
                .build();
    }
}
