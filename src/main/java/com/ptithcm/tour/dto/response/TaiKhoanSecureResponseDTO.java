package com.ptithcm.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaiKhoanSecureResponseDTO {
    private String ho;
    private String ten;
    private String phai;
    private String ngaySinh;
}
