package com.example.web.controller;

import com.example.web.model.MauSac;
import com.example.web.service.impl.IMauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.UUID;

@Controller
@RequestMapping("mausac")
public class MauSacController {

    @Autowired
    IMauSacService iMauSacService;
    Page<MauSac> list;

    @GetMapping("/hienthi")
    String getSideBar(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 3);
        list = iMauSacService.findAll(pageable);
        model.addAttribute("list", list);
        return "qlimausac/mausac";
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable(name = "id") String id) {
        iMauSacService.deleteById(UUID.fromString(id));
        return "redirect:/mausac/hienthi";
    }
}
