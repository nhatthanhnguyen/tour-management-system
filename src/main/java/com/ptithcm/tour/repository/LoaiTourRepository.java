package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.LoaiTour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaiTourRepository extends JpaRepository<LoaiTour, Long> {
    @Query("select lt from LoaiTour lt " +
            "where (lt.tenLoaiTour like CONCAT('%', :query, '%') " +
            "or  lt.moTa like CONCAT('%', :query, '%'))")
    Page<LoaiTour> getAllPaginationWithCondition(@Param("query") String textSearch, Pageable pageable);

    @Query("select lt from LoaiTour lt " +
            "where (lt.tenLoaiTour like CONCAT('%', :query, '%') " +
            "or  lt.moTa like CONCAT('%', :query, '%'))")
    List<LoaiTour> getAllWithCondition(@Param("query") String textSearch, Sort sort);
}
