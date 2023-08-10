package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.DiaDiemRequestDTO;
import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.DiaDiemResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;

import java.util.List;

public interface DiaDiemService {
    List<DiaDiemResponseDTO> getAllWithCondition(LinkDTO linkDTO);

    PageDataDTO<DiaDiemResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO);

    DiaDiemResponseDTO getById(Long id);

    DiaDiemResponseDTO save(DiaDiemRequestDTO diaDiemRequestDTO);
}
