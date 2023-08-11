package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.PhanHoi;
import com.ptithcm.tour.model.PhanHoiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhanHoiRepository extends JpaRepository<PhanHoi, PhanHoiId> {
    @Query("select ph from PhanHoi ph join fetch ph.taiKhoan where ph.taiKhoan.id = :id")
    List<PhanHoi> getByTaiKhoan(@Param("id") Long maTaiKhoan);

    @Query("select ph from PhanHoi ph join fetch ph.tour where ph.tour.id = :id")
    List<PhanHoi> getByTour(@Param("id") Long id);
}
