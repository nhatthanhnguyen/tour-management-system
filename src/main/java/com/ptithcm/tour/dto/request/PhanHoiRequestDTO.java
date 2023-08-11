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
public class PhanHoiRequestDTO {
    private Long maTour;
    private String noiDung;
    private LocalDateTime thoiGian;
}
