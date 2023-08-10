package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LoginRequestDTO;
import com.ptithcm.tour.dto.request.TaiKhoanRequestDTO;
import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.exception.BadCredentialException;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.LoaiTaiKhoanMapper;
import com.ptithcm.tour.mapper.TaiKhoanMapper;
import com.ptithcm.tour.model.LoaiTaiKhoan;
import com.ptithcm.tour.model.TaiKhoan;
import com.ptithcm.tour.repository.LoaiTaiKhoanRepository;
import com.ptithcm.tour.repository.TaiKhoanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_RESPONSE;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private LoaiTaiKhoanRepository loaiTaiKhoanRepository;

    @Autowired
    private TaiKhoanMapper taiKhoanMapper;

    @Override
    public TaiKhoanResponseDTO login(LoginRequestDTO loginRequestDTO) {
        String sdt = loginRequestDTO.getSdt();
        TaiKhoan taiKhoan = taiKhoanRepository.getTaiKhoansBySdt(sdt)
                .orElseThrow(
                        () -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Tài khoản", "Số điện thoại", sdt)
                        )
                );
        if (!taiKhoan.getMatKhau().equals(loginRequestDTO.getPassword())) {
            throw new BadCredentialException("Tài khoản hoặc mật khẩu bị sai");
        }
        return taiKhoanMapper.toResponseDTO(taiKhoan);
    }

    @Override
    public TaiKhoanResponseDTO register(TaiKhoanRequestDTO taiKhoanRequestDTO) {
        String sdt = taiKhoanRequestDTO.getSdt();
        TaiKhoan foundTaiKhoan = taiKhoanRepository.getTaiKhoansBySdt(sdt).orElse(null);
        if (foundTaiKhoan != null) {
            throw new BadCredentialException("Số điện thoại đã có người sử dụng");
        }
        TaiKhoan taiKhoan = new TaiKhoan();
        Long maLoaiTaiKhoan = taiKhoanRequestDTO.getMaLoaiTaiKhoan();
        LoaiTaiKhoan loaiTaiKhoan = loaiTaiKhoanRepository
                .findById(maLoaiTaiKhoan)
                .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tài khoản", "Mã loại tài khoản", maLoaiTaiKhoan)));
        BeanUtils.copyProperties(taiKhoanRequestDTO, taiKhoan, "maLoaiTaiKhoan");
        taiKhoan.setLoaiTaiKhoan(loaiTaiKhoan);
        taiKhoan = taiKhoanRepository.save(taiKhoan);
        return taiKhoanMapper.toResponseDTO(taiKhoan);
    }
}
