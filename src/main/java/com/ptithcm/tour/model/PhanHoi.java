package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "phan_hoi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhanHoi {
    @EmbeddedId
    private PhanHoiId id;
    @ManyToOne
    @MapsId("maTour")
    @JoinColumn(name = "ma_tour")
    private Tour tour;
    @ManyToOne
    @MapsId("maTaiKhoan")
    @JoinColumn(name = "ma_tai_khoan")
    private TaiKhoan taiKhoan;
    private String noiDung;
    private LocalDateTime thoiGian;
}
