package com.ptithcm.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaDiemResponseDTO {
    private Long maDiaDiem;
    private String tenDiaDiem;
    private String moTa;
    private String tinhThanh;
}
