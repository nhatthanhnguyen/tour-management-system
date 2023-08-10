package com.ptithcm.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaiKhoanResponseDTO {
    private Long maTaiKhoan;
    private String ho;
    private String ten;
    private String sdt;
    private String phai;
    private String ngaySinh;
    private LoaiTaiKhoanResponseDTO loaiTaiKhoan;
}
