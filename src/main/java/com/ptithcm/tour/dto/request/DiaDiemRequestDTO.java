package com.ptithcm.tour.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaDiemRequestDTO {
    private Long maDiaDiem;
    private String tenDiaDiem;
    private String moTa;
    private String tinhThanh;
}
