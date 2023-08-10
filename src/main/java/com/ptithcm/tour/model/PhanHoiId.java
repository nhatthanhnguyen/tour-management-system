package com.ptithcm.tour.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhanHoiId implements Serializable {
    @Column(name = "ma_tour")
    private Long maTour;
    @Column(name = "ma_tai_khoan")
    private Long maTaiKhoan;
}
