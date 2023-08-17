package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.LoaiTourRequestDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LoaiTourResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.service.LoaiTourService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/loaiTour")
public class LoaiTourController {
    @Autowired
    private LoaiTourService loaiTourService;

    @GetMapping("/all")
    public List<LoaiTourResponseDTO> getAllWithCondition(
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return loaiTourService.getAllWithCondition(
                new LinkDTO(searchText, List.of(sort))
        );
    }

    @GetMapping
    public PageDataDTO<LoaiTourResponseDTO> getAllPaginationWithCondition(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return loaiTourService.getAllPaginationWithCondition(
                new PageLinkDTO(page, size, searchText, List.of(sort))
        );
    }

    @PostMapping
    @SecurityRequirement(name = "bearer")
    public LoaiTourResponseDTO save(@RequestBody LoaiTourRequestDTO loaiTourRequestDTO) {
        return loaiTourService.save(loaiTourRequestDTO);
    }

    @GetMapping("{id}")
    public LoaiTourResponseDTO getById(@PathVariable("id") Long id) {
        return loaiTourService.getById(id);
    }
}
