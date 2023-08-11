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
public class ThamGiaTourResponseDTO {
    private Long sttThamGia;
    private TaiKhoanSecureResponseDTO taiKhoan;
    private TourResponseDTO tour;
    private LocalDateTime checkin;
    private String ghiChu;
    private String diaDiemDon;
    private String viTri;
}
