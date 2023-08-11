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
public class PhanHoiResponseDTO {
    private TaiKhoanSecureResponseDTO taiKhoan;
    private TourResponseDTO tour;
    private String noiDung;
    private LocalDateTime thoiGian;
}
