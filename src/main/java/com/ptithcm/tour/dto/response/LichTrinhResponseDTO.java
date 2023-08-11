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
public class LichTrinhResponseDTO {
    private Long sttLichTrinh;
    private DiaDiemResponseDTO diaDiem;
    private TourResponseDTO tour;
    private String noiDungLichTrinh;
    private LocalDateTime thoiGianBatDau;
    private String trangThai;
}
