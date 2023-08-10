package com.ptithcm.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dia_diem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDiaDiem")
    private Long id;
    private String tenDiaDiem;
    @Column(columnDefinition = "TEXT")
    private String moTa;
    private String tinhThanh;
}
