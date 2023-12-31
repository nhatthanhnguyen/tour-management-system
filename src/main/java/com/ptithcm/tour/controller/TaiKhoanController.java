package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.service.TaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",
        allowedHeaders = {"Authorization"},
        exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"}
)
@RequestMapping("/api/taiKhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/me")
    @SecurityRequirement(name = "bearer")
    public TaiKhoanResponseDTO getCurrentUserLogin() {
        return taiKhoanService.getCurrentUser();
    }


}
