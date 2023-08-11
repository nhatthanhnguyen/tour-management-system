package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.PhanHoiRequestDTO;
import com.ptithcm.tour.dto.response.PhanHoiResponseDTO;
import com.ptithcm.tour.exception.BadCredentialException;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.PhanHoiMapper;
import com.ptithcm.tour.model.PhanHoi;
import com.ptithcm.tour.model.PhanHoiId;
import com.ptithcm.tour.model.TaiKhoan;
import com.ptithcm.tour.model.Tour;
import com.ptithcm.tour.repository.PhanHoiRepository;
import com.ptithcm.tour.repository.TaiKhoanRepository;
import com.ptithcm.tour.repository.TourRepository;
import com.ptithcm.tour.utils.Helpers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_RESPONSE;

@Service
public class PhanHoiServiceImpl implements PhanHoiService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private PhanHoiRepository phanHoiRepository;

    @Autowired
    private PhanHoiMapper phanHoiMapper;

    @Override
    public PhanHoiResponseDTO save(PhanHoiRequestDTO phanHoiRequestDTO) {
        String username = Helpers.getCurrentUsername();
        if (username == null) {
            throw new BadCredentialException("Tài khoản chưa được login");
        }
        TaiKhoan taiKhoan = taiKhoanRepository.getTaiKhoanBySdt(username)
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tài khoản",
                        "Số điện thoại",
                        username
                )));
        Tour tour = tourRepository.findById(phanHoiRequestDTO.getMaTour())
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tour",
                        "Mã tour",
                        phanHoiRequestDTO.getMaTour()
                )));
        PhanHoiId phanHoiId = new PhanHoiId(tour.getId(), taiKhoan.getId());
        PhanHoi phanHoi = phanHoiRepository.findById(phanHoiId)
                .orElse(PhanHoi.builder()
                        .id(phanHoiId)
                        .taiKhoan(taiKhoan)
                        .tour(tour)
                        .build()
                );
        BeanUtils.copyProperties(phanHoiRequestDTO, phanHoi, "maTour");
        phanHoi = phanHoiRepository.save(phanHoi);
        return phanHoiMapper.toResponseDTO(phanHoi);
    }

    @Override
    public List<PhanHoiResponseDTO> getPhanHoiByCurrentUser() {
        String username = Helpers.getCurrentUsername();
        if (username == null) {
            throw new BadCredentialException("Tài khoản chưa được login");
        }
        TaiKhoan taiKhoan = taiKhoanRepository.getTaiKhoanBySdt(username)
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tài khoản",
                        "Số điện thoại",
                        username
                )));
        return phanHoiRepository.getByTaiKhoan(taiKhoan.getId())
                .stream()
                .map(phanHoi -> phanHoiMapper.toResponseDTO(phanHoi))
                .collect(Collectors.toList());
    }

    @Override
    public List<PhanHoiResponseDTO> getPhanHoiByTour(Long maTour) {
        Tour tour = tourRepository.findById(maTour)
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tour",
                        "Mã tour",
                        maTour
                )));
        return phanHoiRepository.getByTour(tour.getId())
                .stream()
                .map(phanHoi -> phanHoiMapper.toResponseDTO(phanHoi))
                .collect(Collectors.toList());
    }
}
