package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
    Optional<TaiKhoan> getTaiKhoansBySdt(String sdt);
}
