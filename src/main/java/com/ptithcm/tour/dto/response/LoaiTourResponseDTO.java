package com.ptithcm.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTourResponseDTO {
    private Long maLoaiTour;
    private String tenLoaiTour;
    private String moTa;
}
