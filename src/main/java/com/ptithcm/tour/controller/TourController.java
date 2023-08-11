package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.request.TourRequestDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.dto.response.TourResponseDTO;
import com.ptithcm.tour.service.TourService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public List<TourResponseDTO> getAllWithCondition(
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return tourService.getAllWithCondition(
                new LinkDTO(searchText, List.of(sort))
        );
    }

    @GetMapping
    public PageDataDTO<TourResponseDTO> getAllPaginationWithCondition(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return tourService.getAllPaginationWithCondition(
                new PageLinkDTO(page, size, searchText, List.of(sort))
        );
    }

    @PostMapping
    @SecurityRequirement(name = "bearer")
    public TourResponseDTO save(@RequestBody TourRequestDTO tourRequestDTO) {
        return tourService.save(tourRequestDTO);
    }

    @GetMapping("/{id}")
    public TourResponseDTO getById(@PathVariable("id") Long id) {
        return tourService.getById(id);
    }
}
