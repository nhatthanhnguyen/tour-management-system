package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query("select t from Tour t " +
            "where (t.moTa like concat('%', :query, '%') " +
            "or (t.diemDen like concat('%', :query, '%')) " +
            "or (t.diemDi like concat('%', :query, '%')))")
    Page<Tour> getAllPaginationWithCondition(@Param("query") String searchText, Pageable pageable);

    @Query("select t from Tour t " +
            "where (t.moTa like concat('%', :query, '%') " +
            "or (t.diemDen like concat('%', :query, '%')) " +
            "or (t.diemDi like concat('%', :query, '%')))")
    List<Tour> getAllWithCondition(@Param("query") String searchText, Sort sort);
}
