package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tham_gia_tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThamGiaTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STTThamGia")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ma_tour")
    private Tour tour;
    @ManyToOne
    @JoinColumn(name = "ma_tai_khoan")
    private TaiKhoan taiKhoan;
    private LocalDateTime checkin;
    @Column(columnDefinition = "TEXT")
    private String ghiChu;
    private String diaDiemDon;
    @Column(columnDefinition = "TEXT")
    private String viTri;
}
