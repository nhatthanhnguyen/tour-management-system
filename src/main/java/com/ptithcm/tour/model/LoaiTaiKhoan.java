package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LoaiTaiKhoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_tk")
    private Long id;
    @Column(name = "ten_loai_tk")
    private String tenLoaiTK;
    @Column(columnDefinition = "TEXT")
    private String ghiChu;
}
