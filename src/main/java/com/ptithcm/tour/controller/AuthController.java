package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.LoginRequestDTO;
import com.ptithcm.tour.dto.request.TaiKhoanRequestDTO;
import com.ptithcm.tour.dto.response.JwtResponseDTO;
import com.ptithcm.tour.dto.response.MessageResponseDTO;
import com.ptithcm.tour.service.TaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return taiKhoanService.login(loginRequestDTO);
    }

    @PostMapping("/register")
    public MessageResponseDTO register(@RequestBody TaiKhoanRequestDTO taiKhoanRequestDTO) {
        return taiKhoanService.register(taiKhoanRequestDTO);
    }
}
