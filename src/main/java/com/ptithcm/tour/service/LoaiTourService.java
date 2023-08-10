package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.LoaiTourRequestDTO;
import com.ptithcm.tour.dto.response.LoaiTourResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;

import java.util.List;

public interface LoaiTourService {
    LoaiTourResponseDTO getById(Long id);
    LoaiTourResponseDTO save(LoaiTourRequestDTO loaiTourRequestDTO);
    PageDataDTO<LoaiTourResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO);
    List<LoaiTourResponseDTO> getAllWithCondition(LinkDTO linkDTO);
}
