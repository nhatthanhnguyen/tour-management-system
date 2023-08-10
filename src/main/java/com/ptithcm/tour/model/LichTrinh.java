package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lich_trinh")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LichTrinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STTLichTrinh")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ma_dia_diem")
    private DiaDiem diaDiem;
    @ManyToOne
    @JoinColumn(name = "ma_tour")
    private Tour tour;
    @Column(columnDefinition = "TEXT")
    private String noiDungLichTrinh;
    private LocalDateTime thoiGianBatDau;
    private String trangThai;
}
