package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LichTrinhRequestDTO;
import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LichTrinhResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;

import java.util.List;

public interface LichTrinhService {
    PageDataDTO<LichTrinhResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO);

    List<LichTrinhResponseDTO> getAllWithCondition(LinkDTO linkDTO);

    LichTrinhResponseDTO save(LichTrinhRequestDTO lichTrinhRequestDTO);

    LichTrinhResponseDTO getById(Long id);
}
