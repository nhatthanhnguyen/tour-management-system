package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTour")
    private Long id;
    private String diemDen;
    private String diemDi;
    @Column(columnDefinition = "TEXT")
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "ma_loai_tour")
    private LoaiTour loaiTour;
    private Long gia;
    private String trangThai;
    @Column(columnDefinition = "TEXT")
    private String image;
    private LocalDateTime ngayBatDau;
}
