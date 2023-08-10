package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LoginRequestDTO;
import com.ptithcm.tour.dto.request.TaiKhoanRequestDTO;
import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;

public interface TaiKhoanService {
    TaiKhoanResponseDTO login(LoginRequestDTO loginRequestDTO);

    TaiKhoanResponseDTO register(TaiKhoanRequestDTO taiKhoanRequestDTO);
}
