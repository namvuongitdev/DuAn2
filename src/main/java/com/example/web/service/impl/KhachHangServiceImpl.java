package com.example.web.service.impl;

import com.example.web.model.KhachHang;
import com.example.web.repository.IKhachHangRepository;
import com.example.web.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements IKhachHangService {
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll(Sort.by(Sort.Direction.ASC,"hoTen"));
    }

    @Override
    public KhachHang getOne(String id) {
        return khachHangRepository.getReferenceById(id);
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(String id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Page<KhachHang> pagination(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public List<KhachHang> searchByName(String name) {
        return khachHangRepository.searchByName(name);
    }

    @Override
    public List<KhachHang> searchByStatus(Integer status) {
        return khachHangRepository.searchByStatus(status);
    }
}
