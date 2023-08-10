package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
