package com.ptithcm.tour.controller;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.LoaiTaiKhoanRequestDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LoaiTaiKhoanResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.service.LoaiTaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/loaiTaiKhoan")
public class LoaiTaiKhoanController {
    @Autowired
    private LoaiTaiKhoanService loaiTaiKhoanService;

    @GetMapping("/all")
    public List<LoaiTaiKhoanResponseDTO> getAllWithCondition(
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return loaiTaiKhoanService.getAllWithCondition(
                new LinkDTO(searchText, List.of(sort))
        );
    }

    @GetMapping
    public PageDataDTO<LoaiTaiKhoanResponseDTO> getAllPaginationWithCondition(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
            @RequestParam(value = "sort", required = false, defaultValue = "id,asc") String[] sort
    ) {
        return loaiTaiKhoanService.getAllPaginationWithCondition(
                new PageLinkDTO(page, size, searchText, List.of(sort))
        );
    }

    @PostMapping
    @SecurityRequirement(name = "bearer")
    public LoaiTaiKhoanResponseDTO save(@RequestBody LoaiTaiKhoanRequestDTO loaiTaiKhoanRequestDTO) {
        return loaiTaiKhoanService.save(loaiTaiKhoanRequestDTO);
    }

    @GetMapping("{id}")
    public LoaiTaiKhoanResponseDTO getById(@PathVariable("id") Long id) {
        return loaiTaiKhoanService.getById(id);
    }
}
