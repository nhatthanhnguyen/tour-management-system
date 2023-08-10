package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.LoaiTaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaiTaiKhoanRepository extends JpaRepository<LoaiTaiKhoan, Long> {
    @Query("select ltk from LoaiTaiKhoan ltk " +
            "where (ltk.tenLoaiTK like CONCAT('%', :query, '%') " +
            "or (ltk.ghiChu like CONCAT('%', :query, '%')))")
    Page<LoaiTaiKhoan> getAllPaginationWithCondition(@Param("query") String textSearch, Pageable pageable);

    @Query("select ltk from LoaiTaiKhoan ltk " +
            "where (ltk.tenLoaiTK like CONCAT('%', :query, '%') " +
            "or (ltk.ghiChu like CONCAT('%', :query, '%')))")
    List<LoaiTaiKhoan> getAllWithCondition(@Param("query") String textSearch, Sort sort);
}
