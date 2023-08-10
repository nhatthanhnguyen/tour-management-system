package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LinkDTO;
import com.ptithcm.tour.dto.request.LoaiTaiKhoanRequestDTO;
import com.ptithcm.tour.dto.request.PageLinkDTO;
import com.ptithcm.tour.dto.response.LoaiTaiKhoanResponseDTO;
import com.ptithcm.tour.dto.response.PageDataDTO;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.LoaiTaiKhoanMapper;
import com.ptithcm.tour.model.LoaiTaiKhoan;
import com.ptithcm.tour.repository.LoaiTaiKhoanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_RESPONSE;

@Service
public class LoaiTaiKhoanServiceImpl implements LoaiTaiKhoanService {
    @Autowired
    private LoaiTaiKhoanRepository loaiTaiKhoanRepository;

    @Autowired
    private LoaiTaiKhoanMapper loaiTaiKhoanMapper;

    @Override
    public LoaiTaiKhoanResponseDTO getById(Long id) {
        return loaiTaiKhoanMapper.toResponseDTO(
                loaiTaiKhoanRepository.findById(id).orElseThrow(
                        () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tài khoản", "Mã loại tài khoản", id))
                )
        );
    }

    @Override
    public LoaiTaiKhoanResponseDTO save(LoaiTaiKhoanRequestDTO loaiTaiKhoanRequestDTO) {
        LoaiTaiKhoan loaiTaiKhoan = new LoaiTaiKhoan();
        Long id = loaiTaiKhoanRequestDTO.getMaLoaiTK();
        if (id != null) {
            loaiTaiKhoan = loaiTaiKhoanRepository.findById(id).orElseThrow(
                    () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tài khoản", "Mã loại tài khoản", id))
            );
        }
        BeanUtils.copyProperties(loaiTaiKhoanRequestDTO, loaiTaiKhoan, "id");
        loaiTaiKhoan = loaiTaiKhoanRepository.save(loaiTaiKhoan);
        return loaiTaiKhoanMapper.toResponseDTO(loaiTaiKhoan);
    }

    @Override
    public PageDataDTO<LoaiTaiKhoanResponseDTO> getAllPaginationWithCondition(PageLinkDTO pageLinkDTO) {
        Pageable pagingSort = PageRequest.of(pageLinkDTO.getPage(), pageLinkDTO.getSize(), Sort.by(pageLinkDTO.getSort()));
        Page<LoaiTaiKhoan> loaiTaiKhoanPage = loaiTaiKhoanRepository.getAllPaginationWithCondition(pageLinkDTO.getSearchText(), pagingSort);
        return new PageDataDTO<>(
                loaiTaiKhoanPage.getContent().stream().map(loaiTaiKhoan -> loaiTaiKhoanMapper.toResponseDTO(loaiTaiKhoan)).collect(Collectors.toList()),
                loaiTaiKhoanPage.getTotalPages(),
                loaiTaiKhoanPage.getTotalElements(),
                loaiTaiKhoanPage.hasNext()
        );
    }

    @Override
    public List<LoaiTaiKhoanResponseDTO> getAllWithCondition(LinkDTO linkDTO) {
        return loaiTaiKhoanRepository.getAllWithCondition(linkDTO.getSearchText(), Sort.by(linkDTO.getSort()))
                .stream()
                .map(loaiTaiKhoan -> loaiTaiKhoanMapper.toResponseDTO(loaiTaiKhoan))
                .collect(Collectors.toList());
    }
}
