package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.DiaDiemResponseDTO;
import com.ptithcm.tour.model.DiaDiem;
import org.springframework.stereotype.Component;

@Component
public class DiaDiemMapperImpl implements DiaDiemMapper {
    @Override
    public DiaDiemResponseDTO toResponseDTO(DiaDiem entity) {
        return DiaDiemResponseDTO.builder()
                .maDiaDiem(entity.getId())
                .tenDiaDiem(entity.getTenDiaDiem())
                .moTa(entity.getMoTa())
                .tinhThanh(entity.getTinhThanh()).build();
    }
}
