package com.ptithcm.tour.dto.request;

import com.ptithcm.tour.dto.response.LoaiTourResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourRequestDTO {
    private Long maTour;
    private String diemDen;
    private String diemDi;
    private String moTa;
    private Long maLoaiTour;
    private Long gia;
    private String trangThai;
    private String image;
    private LocalDateTime ngayBatDau;
}
