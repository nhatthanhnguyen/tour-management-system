package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.LoaiTaiKhoanRequestDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LoaiTaiKhoanResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;

import java.util.List;

public interface LoaiTaiKhoanService {
    LoaiTaiKhoanResponseDTO getById(Long id);
    LoaiTaiKhoanResponseDTO save(LoaiTaiKhoanRequestDTO loaiTaiKhoanRequestDTO);
    PageDataDTO<LoaiTaiKhoanResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO);
    List<LoaiTaiKhoanResponseDTO> getAllWithCondition(LinkDTO linkDTO);
}
