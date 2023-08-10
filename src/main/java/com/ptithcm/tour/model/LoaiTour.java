package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LoaiTour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoaiTour")
    private Long id;
    private String tenLoaiTour;
    @Column(columnDefinition = "TEXT")
    private String moTa;
}
