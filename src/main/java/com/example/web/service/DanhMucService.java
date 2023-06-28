package com.example.web.service;

import com.example.web.model.DanhMuc;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhMucService {
    List<DanhMuc> getAll();

    DanhMuc getOne(String id);

    void add(DanhMuc danhMuc);

    void update(DanhMuc danhMuc);

    void delete(String id);

    Page<DanhMuc> page(Integer pageNo, Integer size);
}
