package com.example.web.service;

import com.example.web.model.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IKhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(String id);

    void add(KhachHang khachHang);

    void update(KhachHang khachHang);

    void delete(String id);

    Page<KhachHang> pagination(Integer pageNo, Integer size);

    List<KhachHang> searchByName(String name);

    List<KhachHang> searchByStatus(Integer status);
}
