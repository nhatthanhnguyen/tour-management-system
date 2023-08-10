package com.ptithcm.tour.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTourRequestDTO {
    private Long maLoaiTour;
    private String tenLoaiTour;
    private String moTa;
}
