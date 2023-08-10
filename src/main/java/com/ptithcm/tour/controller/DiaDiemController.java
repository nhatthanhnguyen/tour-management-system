package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.DiaDiemRequestDTO;
import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.DiaDiemResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.service.DiaDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diaDiem")
public class DiaDiemController {
    @Autowired
    private DiaDiemService diaDiemService;

    @GetMapping("/all")
    public List<DiaDiemResponseDTO> getAllWithCondition(
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return diaDiemService.getAllWithCondition(
                new LinkDTO(searchText, List.of(sort))
        );
    }

    @GetMapping
    public PageDataDTO<DiaDiemResponseDTO> getAllPaginationWithCondition(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return diaDiemService.getAllPaginationWithCondition(
                new PageLinkDTO(page, size, searchText, List.of(sort))
        );
    }

    @PostMapping
    public DiaDiemResponseDTO save(@RequestBody DiaDiemRequestDTO diaDiemRequestDTO) {
        return diaDiemService.save(diaDiemRequestDTO);
    }

    @GetMapping("{id}")
    public DiaDiemResponseDTO getById(@PathVariable("id") Long id) {
        return diaDiemService.getById(id);
    }
}
