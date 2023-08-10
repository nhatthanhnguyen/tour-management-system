package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.DiaDiem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiaDiemRepository extends JpaRepository<DiaDiem, Long> {
    @Query("select dd from DiaDiem dd " +
            "where (dd.moTa like CONCAT('%', :query, '%') " +
            "or dd.tenDiaDiem like CONCAT('%', :query, '%') " +
            "or dd.tinhThanh like CONCAT('%', :query, '%'))")
    Page<DiaDiem> getAllPaginationWithCondition(@Param("query") String textSearch, Pageable pageable);

    @Query("select dd from DiaDiem dd " +
            "where (dd.moTa like CONCAT('%', :query, '%') " +
            "or dd.tenDiaDiem like CONCAT('%', :query, '%') " +
            "or dd.tinhThanh like CONCAT('%', :query, '%'))")
    List<DiaDiem> getAllWithCondition(@Param("query") String textSearch, Sort sort);
}
