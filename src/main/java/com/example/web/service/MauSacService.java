package com.example.web.service;

import com.example.web.model.MauSac;
import com.example.web.repository.IMauSacRepository;
import com.example.web.service.impl.IMauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MauSacService implements IMauSacService {

    @Autowired
    IMauSacRepository mauSacRepository;

    @Override
    public Page<MauSac> findAll(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public void deleteById(UUID id) {
        mauSacRepository.delele(id);
    }
}
