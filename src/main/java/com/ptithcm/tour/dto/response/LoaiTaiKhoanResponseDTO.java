package com.ptithcm.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTaiKhoanResponseDTO {
    private Long maLoaiTK;
    private String tenLoaiTK;
    private String ghiChu;
}
