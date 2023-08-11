package com.ptithcm.tour.service;

import com.ptithcm.tour.dto.request.LoginRequestDTO;
import com.ptithcm.tour.dto.request.TaiKhoanRequestDTO;
import com.ptithcm.tour.dto.response.JwtResponseDTO;
import com.ptithcm.tour.dto.response.MessageResponseDTO;
import com.ptithcm.tour.dto.response.TaiKhoanResponseDTO;
import com.ptithcm.tour.exception.BadCredentialException;
import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.mapper.TaiKhoanMapper;
import com.ptithcm.tour.model.LoaiTaiKhoan;
import com.ptithcm.tour.model.TaiKhoan;
import com.ptithcm.tour.repository.LoaiTaiKhoanRepository;
import com.ptithcm.tour.repository.TaiKhoanRepository;
import com.ptithcm.tour.security.jwt.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ptithcm.tour.utils.Constants.NOT_FOUND_RESPONSE;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private LoaiTaiKhoanRepository loaiTaiKhoanRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TaiKhoanMapper taiKhoanMapper;

    @Override
    public JwtResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return JwtResponseDTO.builder()
                .accessToken(jwt).build();
    }

    @Override
    public MessageResponseDTO register(TaiKhoanRequestDTO taiKhoanRequestDTO) {
        if (taiKhoanRepository.existsBySdt(taiKhoanRequestDTO.getSdt())) {
            throw new BadCredentialException("Số điện thoại đã được đăng ký");
        }
        LoaiTaiKhoan loaiTaiKhoan = loaiTaiKhoanRepository.findById(taiKhoanRequestDTO.getMaLoaiTaiKhoan())
                .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_RESPONSE, "Loại tài khoản", "Mã loại tài khoản", taiKhoanRequestDTO.getMaLoaiTaiKhoan())));
        TaiKhoan taiKhoan = new TaiKhoan();
        BeanUtils.copyProperties(taiKhoanRequestDTO, taiKhoan, "maLoaiTaiKhoan", "matKhau");
        taiKhoan.setLoaiTaiKhoan(loaiTaiKhoan);
        taiKhoan.setMatKhau(encoder.encode(taiKhoanRequestDTO.getMatKhau()));
        taiKhoanRepository.save(taiKhoan);
        return MessageResponseDTO.builder()
                .code(HttpStatus.OK.value())
                .message("Tạo tài khoản thành công")
                .build();
    }

    @Override
    public TaiKhoanResponseDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            return taiKhoanMapper.toResponseDTO(
                    taiKhoanRepository.getTaiKhoanBySdt(currentUsername).orElseThrow(
                            () -> new NotFoundException(String.format(
                                    NOT_FOUND_RESPONSE,
                                    "Tài khoản",
                                    "Số điện thoại",
                                    currentUsername
                            ))
                    )
            );
        }
        return null;
    }
}
