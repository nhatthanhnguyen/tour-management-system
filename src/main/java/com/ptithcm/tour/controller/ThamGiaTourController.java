package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.ThamGiaTourRequestDTO;
import com.ptithcm.tour.dto.response.ThamGiaTourResponseDTO;
import com.ptithcm.tour.service.ThamGiaTourService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thamGia")
public class ThamGiaTourController {
    @Autowired
    private ThamGiaTourService thamGiaTourService;


    @PostMapping
    @SecurityRequirement(name = "bearer")
    public ThamGiaTourResponseDTO save(@RequestBody ThamGiaTourRequestDTO requestDTO) {
        return thamGiaTourService.save(requestDTO);
    }

    @GetMapping("/tour/{id}")
    public List<ThamGiaTourResponseDTO> getByTour(@PathVariable("id") Long maTour) {
        return thamGiaTourService.getThamGiaTourByTour(maTour);
    }

    @GetMapping("/me")
    @SecurityRequirement(name = "bearer")
    public List<ThamGiaTourResponseDTO> getByMe() {
        return thamGiaTourService.getThamGiaTourByUser();
    }
}
