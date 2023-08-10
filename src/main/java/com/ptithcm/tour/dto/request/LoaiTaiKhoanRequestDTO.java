package com.ptithcm.tour.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTaiKhoanRequestDTO {
    private Long maLoaiTK;
    private String tenLoaiTK;
    private String ghiChu;
}
