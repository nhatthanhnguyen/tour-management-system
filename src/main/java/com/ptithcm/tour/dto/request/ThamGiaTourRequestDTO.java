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
public class ThamGiaTourRequestDTO {
    private Long sttThamGia;
    private Long maTour;
    private LocalDateTime checkin;
    private String ghiChu;
    private String diaDiemDon;
    private String viTri;
}
