package com.ptithcm.tour.security.service;

import com.ptithcm.tour.exception.NotFoundException;
import com.ptithcm.tour.model.TaiKhoan;
import com.ptithcm.tour.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.getTaiKhoanBySdt(username)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy tài khoản"));
        return UserDetailsImpl.build(taiKhoan);
    }
}
