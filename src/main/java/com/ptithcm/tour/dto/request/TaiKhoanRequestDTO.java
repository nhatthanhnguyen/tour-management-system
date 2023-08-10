package com.ptithcm.tour.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanRequestDTO {
    private String ho;
    private String ten;
    private String sdt;
    private String phai;
    private String ngaySinh;
    private String matKhau;
    private Long maLoaiTaiKhoan;
}
