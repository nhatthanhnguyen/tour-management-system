package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.request.TourRequestDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.dto.response.TourResponseDTO;

import java.util.List;

public interface TourService {
    PageDataDTO<TourResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO);

    List<TourResponseDTO> getAllWithCondition(LinkDTO linkDTO);

    TourResponseDTO save(TourRequestDTO tourRequestDTO);

    TourResponseDTO getById(Long id);
}
