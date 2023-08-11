package com.ptithcm.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourResponseDTO {
    private Long maTour;
    private String diemDen;
    private String diemDi;
    private String moTa;
    private LoaiTourResponseDTO loaiTour;
    private Long gia;
    private String trangThai;
    private String image;
    private LocalDateTime ngayBatDau;
}
