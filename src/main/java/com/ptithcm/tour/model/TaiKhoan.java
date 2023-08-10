package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TaiKhoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTaiKhoan")
    private Long id;
    private String ho;
    private String ten;
    private String sdt;
    private String phai;
    private String ngaySinh;
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "ma_loai_tk")
    private LoaiTaiKhoan loaiTaiKhoan;
}
