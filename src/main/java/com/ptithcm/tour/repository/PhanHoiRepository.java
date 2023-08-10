package com.ptithcm.tour.repository;

import com.ptithcm.tour.model.PhanHoi;
import com.ptithcm.tour.model.PhanHoiId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhanHoiRepository extends JpaRepository<PhanHoi, PhanHoiId> {
}
