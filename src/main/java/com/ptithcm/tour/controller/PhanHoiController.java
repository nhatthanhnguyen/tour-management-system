package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.PhanHoiRequestDTO;
import com.ptithcm.tour.dto.response.PhanHoiResponseDTO;
import com.ptithcm.tour.service.PhanHoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phanHoi")
public class PhanHoiController {
    @Autowired
    private PhanHoiService phanHoiService;

    @PostMapping
    public PhanHoiResponseDTO save(@RequestBody PhanHoiRequestDTO phanHoiRequestDTO) {
        return phanHoiService.save(phanHoiRequestDTO);
    }

    @GetMapping("/tour/{id}")
    public List<PhanHoiResponseDTO> getPhanHoiByTourId(@PathVariable("id") Long maTour) {
        return phanHoiService.getPhanHoiByTour(maTour);
    }

    @GetMapping("/me")
    public List<PhanHoiResponseDTO> getPhanHoiByMe() {
        return phanHoiService.getPhanHoiByCurrentUser();
    }
}
