package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taiKhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/me")
    public TaiKhoanResponseDTO getCurrentUserLogin() {
        return taiKhoanService.getCurrentUser();
    }


}
