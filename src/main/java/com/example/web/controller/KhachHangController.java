package com.example.web.controller;

import com.example.web.model.KhachHang;
import com.example.web.service.impl.KhachHangServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/khach-hang/")
public class KhachHangController {
    @Autowired
    private KhachHangServiceImpl khachHangService;

    @GetMapping("hien-thi")
    public String hienThi(Model model,@RequestParam(value = "p",defaultValue = "0")Integer pageNo) {
        model.addAttribute("lst", khachHangService.getAll());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalsPage", khachHangService.pagination(pageNo,5).getTotalPages());
        return "/khachhang/khach-hang";
    }
    @GetMapping("hien-thi/{p}")
    public String phanTrang(Model model,@PathVariable("p")Integer pageNo) {
        model.addAttribute("lst", khachHangService.pagination(pageNo,5).getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalsPage", khachHangService.pagination(pageNo,5).getTotalPages());
        return "/khachhang/khach-hang";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "/khachhang/add-khach-hang";
    }

    @GetMapping("search")
    public String search(Model model,
                         @RequestParam("timKiem") String name,
                         @RequestParam("status") Integer status) {
        if (name.isBlank()){
            model.addAttribute("lst", khachHangService.searchByStatus(status));
        }else {
            model.addAttribute("lst", khachHangService.searchByName(name));
        }
        return "/khachhang/khach-hang";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") String id, @ModelAttribute("khachHang") KhachHang khachHang) {
        khachHang = khachHangService.getOne(id);
        model.addAttribute("khachHang", khachHang);
        return "/khachhang/update-khach-hang";
    }
    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
         khachHangService.delete(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "/khachhang/add-khach-hang";
        }
        UUID id = UUID.randomUUID();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        khachHang.setTrangThai(0);
        khachHang.setNgayTao(date);
        khachHang.setId(String.valueOf(id));
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                         @PathVariable("id") String id,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()){
            khachHang = khachHangService.getOne(id);
            model.addAttribute("khachHang", khachHang);
            return "/khachhang/update-khach-hang";
        }else {
            khachHang.setNgayTao(khachHangService.getOne(id).getNgayTao());
            khachHang.setId(String.valueOf(id));
            khachHangService.update(khachHang);
            return "redirect:/khach-hang/hien-thi";
        }
    }
}
