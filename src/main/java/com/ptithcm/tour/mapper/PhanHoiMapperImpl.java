package com.ptithcm.tour.mapper;

import com.ptithcm.tour.dto.response.PhanHoiResponseDTO;
import com.ptithcm.tour.model.PhanHoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhanHoiMapperImpl implements PhanHoiMapper {
    @Autowired
    private TaiKhoanMapper taiKhoanMapper;

    @Autowired
    private TourMapper tourMapper;

    @Override
    public PhanHoiResponseDTO toResponseDTO(PhanHoi entity) {
        return PhanHoiResponseDTO.builder()
                .noiDung(entity.getNoiDung())
                .taiKhoan(taiKhoanMapper.toSecureResponseDTO(entity.getTaiKhoan()))
                .tour(tourMapper.toResponseDTO(entity.getTour()))
                .noiDung(entity.getNoiDung())
                .thoiGian(entity.getThoiGian()).build();
    }
}
