package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LoginRequestDTO;
import com.ptithcm.tour.dto.request.TaiKhoanRequestDTO;
import com.ptithcm.tour.dto.response.JwtResponseDTO;
import com.ptithcm.tour.dto.response.MessageResponseDTO;
import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;

public interface TaiKhoanService {
    JwtResponseDTO login(LoginRequestDTO loginRequestDTO);

    MessageResponseDTO register(TaiKhoanRequestDTO taiKhoanRequestDTO);

    TaiKhoanResponseDTO getCurrentUser();
}
