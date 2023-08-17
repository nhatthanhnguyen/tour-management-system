package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.ThamGiaTourRequestDTO;
import com.ptithcm.tour.dto.response.MessageResponseDTO;
import com.ptithcm.tour.dto.response.ThamGiaTourResponseDTO;
import com.ptithcm.tour.exception.BadCredentialException;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.ThamGiaTourMapper;
import com.ptithcm.tour.model.TaiKhoan;
import com.ptithcm.tour.model.ThamGiaTour;
import com.ptithcm.tour.model.Tour;
import com.ptithcm.tour.repository.TaiKhoanRepository;
import com.ptithcm.tour.repository.ThamGiaTourRepository;
import com.ptithcm.tour.repository.TourRepository;
import com.ptithcm.tour.utils.Helpers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_RESPONSE;

@Service
public class ThamGiaTourServiceImpl implements ThamGiaTourService {
    @Autowired
    private ThamGiaTourRepository thamGiaTourRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private ThamGiaTourMapper thamGiaTourMapper;

    @Override
    public ThamGiaTourResponseDTO save(ThamGiaTourRequestDTO thamGiaTourRequestDTO) {
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
        Tour tour = tourRepository.findById(thamGiaTourRequestDTO.getMaTour())
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tour",
                        "Mã tour",
                        thamGiaTourRequestDTO.getMaTour()
                )));
        Long id = thamGiaTourRequestDTO.getSttThamGia();
        ThamGiaTour thamGiaTour = new ThamGiaTour();
        if (id != null) {
            thamGiaTour = thamGiaTourRepository.findById(thamGiaTourRequestDTO.getSttThamGia())
                    .orElseThrow(() -> new NotFoundException(String.format(
                            NOT_FOUND_RESPONSE,
                            "Lượt tham gia",
                            "Số thứ tự",
                            thamGiaTourRequestDTO.getSttThamGia()
                    )));
        }
        BeanUtils.copyProperties(thamGiaTourRequestDTO, thamGiaTour, "maTour");
        thamGiaTour.setTour(tour);
        thamGiaTour.setTaiKhoan(taiKhoan);
        thamGiaTour = thamGiaTourRepository.save(thamGiaTour);
        return thamGiaTourMapper.toResponseDTO(thamGiaTour);
    }

    @Override
    public List<ThamGiaTourResponseDTO> getThamGiaTourByTour(Long maTour) {
        Tour tour = tourRepository.findById(maTour)
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tour",
                        "Mã tour",
                        maTour
                )));
        return thamGiaTourRepository.getByTour(tour.getId())
                .stream()
                .map(o -> thamGiaTourMapper.toResponseDTO(o))
                .collect(Collectors.toList());
    }

    @Override
    public List<ThamGiaTourResponseDTO> getThamGiaTourByUser() {
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
        return thamGiaTourRepository.getByTaiKhoan(taiKhoan.getId())
                .stream()
                .map(o -> thamGiaTourMapper.toResponseDTO(o))
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponseDTO deleteThamGiaTourById(Long sttThamGia) {
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
        ThamGiaTour thamGiaTour = thamGiaTourRepository
                .findById(sttThamGia)
                .orElseThrow(() -> new NotFoundException(String.format(
                        NOT_FOUND_RESPONSE,
                        "Tham gia tour",
                        "Số thứ tự tham gia",
                        sttThamGia
                )));
        if (!Objects.equals(thamGiaTour.getTaiKhoan().getId(), taiKhoan.getId())) {
            throw new BadCredentialException("Bạn không có quyền xóa");
        }
        thamGiaTourRepository.deleteById(sttThamGia);
        return new MessageResponseDTO(200, "Xóa tham gia Tour thành công");
    }
}
