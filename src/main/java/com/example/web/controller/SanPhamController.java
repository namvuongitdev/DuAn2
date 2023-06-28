package com.example.web.controller;

import com.example.web.model.ChatLieu;
import com.example.web.model.FormDang;
import com.example.web.model.SanPham;
import com.example.web.service.IChatLieuService;
import com.example.web.service.IFormDangService;
import com.example.web.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("sanpham")
public class SanPhamController {
    @Autowired
    IFormDangService iFormDangService;

    @Autowired
    ISanPhamService iSanPhamService;

    @Autowired
    IChatLieuService iChatLieuService;

    Page<SanPham> list;

    @GetMapping("/hienthi")
    String hienThi(Model model, @RequestParam(defaultValue = "1") int page
    ) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);

        List<FormDang> listForm = iFormDangService.getAll();
        model.addAttribute("listForm", listForm);

        List<ChatLieu> listChat = iChatLieuService.getAll();
        model.addAttribute("listChat", listChat);

        list = iSanPhamService.findAll(pageable);
        model.addAttribute("list", list);

        model.addAttribute("pageNo", page);
        model.addAttribute("page", page != 1 ? page * 5 - 4 : page);
        return "sanpham/sanpham";
    }

    @PostMapping("/add")
    String add(
            @RequestParam(name = "ten") String ten,
            @RequestParam(name = "moTa") String moTa,
            @RequestParam(name = "trangthai") String trangthai,
            @RequestParam(name = "ngaytao") Date ngaytao,
            @RequestParam(name = "gianhap") String gianhap,
            @RequestParam(name = "giaban") String giaban,
            @RequestParam(name = "form") String form,
            @RequestParam(name = "chat") String chat

    ) {

        FormDang formDang = iFormDangService.getOne(UUID.fromString(form));
        ChatLieu chatLieu = iChatLieuService.getOne(UUID.fromString(chat));
        SanPham sanPham = new SanPham( ten, Integer.parseInt(trangthai),
                ngaytao, BigDecimal.valueOf(Double.parseDouble(gianhap)),
                BigDecimal.valueOf(Double.parseDouble(giaban)), moTa, formDang, chatLieu);
        SanPham sanPham1 = iSanPhamService.save(sanPham);
        return "redirect:/sanpham/hienthi";
    }

    @PostMapping("/update")
    String update(
            @RequestParam(name = "ten") String ten,
            @RequestParam(name = "moTa") String moTa,
            @RequestParam(name = "trangthai") String trangthai,
            @RequestParam(name = "ngaytao") Date ngaytao,
            @RequestParam(name = "gianhap") String gianhap,
            @RequestParam(name = "giaban") String giaban,
            @RequestParam(name = "form") String form,
            @RequestParam(name = "chat") String chat,
            @RequestParam(name = "id") String id

    ) {

        FormDang formDang = iFormDangService.getOne(UUID.fromString(form));
        ChatLieu chatLieu = iChatLieuService.getOne(UUID.fromString(chat));
        SanPham sanPham = iSanPhamService.getOne(UUID.fromString(id));

        sanPham.setTen(ten);
        sanPham.setTrangThai(Integer.parseInt(trangthai));
        sanPham.setNgayTao(ngaytao);
        sanPham.setGiaNhap(BigDecimal.valueOf(Double.parseDouble(gianhap)));
        sanPham.setGiaBan(BigDecimal.valueOf(Double.parseDouble(giaban)));
        sanPham.setMoTa(moTa);
        sanPham.setFormDang(formDang);
        sanPham.setChatLieu(chatLieu);
        SanPham sanPham1 = iSanPhamService.save(sanPham);
        return "redirect:/sanpham/hienthi";
    }

    @GetMapping("/layten/{id}")
    @ResponseBody
    public FormDang getForm(@PathVariable(name = "id") String id) {
        FormDang formDang = iFormDangService.getOne(UUID.fromString(id));
        return formDang;
    }

    @GetMapping("/chatlieu/{id}")
    @ResponseBody
    public ChatLieu getChat(@PathVariable(name = "id") String id) {
        ChatLieu chatLieu = iChatLieuService.getOne(UUID.fromString(id));
        return chatLieu;
    }
}
