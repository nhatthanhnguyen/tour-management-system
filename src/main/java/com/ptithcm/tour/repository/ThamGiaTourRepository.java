package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.ThamGiaTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThamGiaTourRepository extends JpaRepository<ThamGiaTour, Long> {
    @Query("select tgt from ThamGiaTour tgt join fetch tgt.tour where tgt.tour.id = :id")
    List<ThamGiaTour> getByTour(@Param("id") Long maTour);

    @Query("select tgt from ThamGiaTour tgt join fetch tgt.taiKhoan where tgt.taiKhoan.id = :id")
    List<ThamGiaTour> getByTaiKhoan(@Param("id") Long maTaiKhoan);
}
