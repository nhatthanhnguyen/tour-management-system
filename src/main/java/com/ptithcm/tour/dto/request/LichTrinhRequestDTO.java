package com.ptithcm.tour.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LichTrinhRequestDTO {
    private Long id;
    private Long maDiaDiem;
    private Long maTour;
    private String noiDungLichTrinh;
    private LocalDateTime thoiGianBatDau;
    private String trangThai;
}
