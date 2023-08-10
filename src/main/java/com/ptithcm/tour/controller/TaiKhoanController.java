package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.LoginRequestDTO;
import com.ptithcm.tour.dto.request.TaiKhoanRequestDTO;
import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/taiKhoan")
@RestController
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping("login")
    public TaiKhoanResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return taiKhoanService.login(loginRequestDTO);
    }

    @PostMapping("register")
    public TaiKhoanResponseDTO register(@RequestBody TaiKhoanRequestDTO taiKhoanRequestDTO) {
        return taiKhoanService.register(taiKhoanRequestDTO);
    }
}
