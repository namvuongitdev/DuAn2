package com.example.web.service.impl;
import com.example.web.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface IMauSacService {

    Page<MauSac> findAll(Pageable pageable);

    void deleteById(UUID id);
}
