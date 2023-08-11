package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.LichTrinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LichTrinhRepository extends JpaRepository<LichTrinh, Long> {
    @Query("select lt from LichTrinh lt " +
            "where (lt.noiDungLichTrinh like concat('%', :query, '%') " +
            "or lt.trangThai like concat('%', :query, '%') " +
            "or lt.diaDiem.tenDiaDiem like concat('%', :query, '%'))")
    Page<LichTrinh> getAllPaginationWithCondition(@Param("query") String searchText, Pageable pageable);

    @Query("select lt from LichTrinh lt " +
            "where (lt.noiDungLichTrinh like concat('%', :query, '%') " +
            "or lt.trangThai like concat('%', :query, '%') " +
            "or lt.diaDiem.tenDiaDiem like concat('%', :query, '%'))")
    List<LichTrinh> getAllWithCondition(@Param("query") String searchText, Sort sort);
}
