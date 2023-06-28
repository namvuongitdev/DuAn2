package com.example.web.controller;

import com.example.web.model.*;
import com.example.web.service.DanhMucService;
import com.example.web.service.IChiTietSanPhamService;
import com.example.web.service.IMauSacService;
import com.example.web.service.ISanPhamService;
import com.example.web.service.impl.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSanPhamController {
    Page<ChiTietSanPham> list;

    @Autowired
    private IChiTietSanPhamService iChiTietSanPhamService;

    @Autowired
    private ISanPhamService iSanPhamService;

    @Autowired
    private IMauSacService iMauSacService;

    @Autowired
    private SizeServiceImpl sizeService;

    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("/hien-thi")
    String hienThi(@RequestParam(defaultValue = "1") Integer page, Model model,
                   @RequestParam(name = "idsp", required = false) String idsp) {
        if (page < 1) page = 1;
        List<MauSac> listMau = iMauSacService.getAll();
        model.addAttribute("listMau", listMau);

        List<Size> listSize = sizeService.getAll();
        model.addAttribute("listSize", listSize);

        List<DanhMuc> listDanh = danhMucService.getAll();
        model.addAttribute("listDanh", listDanh);

        if (idsp != null) {
            model.addAttribute("idsp", idsp);
        }
        Pageable pageable = PageRequest.of(page - 1, 5);
        list = iChiTietSanPhamService.findAll(pageable);
        model.addAttribute("list", list);
        model.addAttribute("pageNo", page);
        model.addAttribute("page", page != 1 ? page * 5 - 4 : page);
        return "chitietsanpham/chitiet";
    }

    @GetMapping("/lay-mau/{id}")
    @ResponseBody
    public MauSac layMau(@PathVariable(name = "id") String id) {
        MauSac mauSac = iMauSacService.getOne(UUID.fromString(id));
        return mauSac;
    }

    @GetMapping("/lay-size/{id}")
    @ResponseBody
    public Size laysize(@PathVariable(name = "id") String id) {
        Size siZe = sizeService.getOne1(UUID.fromString(id));
        return siZe;

    }

    @GetMapping("/lay-danh-muc/{id}")
    @ResponseBody
    public DanhMuc layDanhMuc(@PathVariable(name = "id") String id) {
        DanhMuc danhMuc = danhMucService.getOne1(UUID.fromString(id));
        return danhMuc;
    }

    @PostMapping("/add")
    String add(
            @RequestParam(name = "idsp") String idsp,
            @RequestParam(name = "soluong") String soluong,
            @RequestParam(name = "trangthai") String trangthai,
            @RequestParam(name = "mau") String mau,
            @RequestParam(name = "size") String size,
            @RequestParam(name = "danhmuc") String danhmuc

    ) {

        MauSac mauSac = iMauSacService.getOne(UUID.fromString(mau));
        Size siZe = sizeService.getOne1(UUID.fromString(size));
        DanhMuc danhMuc = danhMucService.getOne1(UUID.fromString(danhmuc));
        SanPham sanPham = iSanPhamService.getOne(UUID.fromString(idsp));

        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(sanPham, Integer.parseInt(soluong), Integer.parseInt(trangthai), mauSac, siZe, danhMuc);
        ChiTietSanPham chiTietSanPham1 = iChiTietSanPhamService.save(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/viewupdate")
    String viewupdate(Model model, @RequestParam(name = "id",required = false) String id) {

       if(id!=null){
           List<MauSac> listMau = iMauSacService.getAll();
           model.addAttribute("listMau", listMau);

           List<Size> listSize = sizeService.getAll();
           model.addAttribute("listSize", listSize);

           List<DanhMuc> listDanh = danhMucService.getAll();
           model.addAttribute("listDanh", listDanh);
           ChiTietSanPham chiTietSanPham = iChiTietSanPhamService.getOne(UUID.fromString(id));
           System.out.println(chiTietSanPham);
           model.addAttribute("sp", chiTietSanPham);
           return "chitietsanpham/update";
       }
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @PostMapping("/update")
    String update(@RequestParam(name = "id",required = false) String id,
                  @RequestParam(name = "soluong") String soluong,
                  @RequestParam(name = "trangthai") String trangthai,
                  @RequestParam(name = "mau") String mau,
                  @RequestParam(name = "size") String size,
                  @RequestParam(name = "danhmuc") String danhmuc) {
        MauSac mauSac = iMauSacService.getOne(UUID.fromString(mau));
        Size siZe = sizeService.getOne1(UUID.fromString(size));
        DanhMuc danhMuc = danhMucService.getOne1(UUID.fromString(danhmuc));
        ChiTietSanPham chiTietSanPham = iChiTietSanPhamService.getOne(UUID.fromString(id));
        SanPham sanPham = chiTietSanPham.getSanPham();
        chiTietSanPham.setSanPham(sanPham);
        chiTietSanPham.setTrangThai(Integer.parseInt(trangthai));
        chiTietSanPham.setDanhMuc(danhMuc);
        chiTietSanPham.setMauSac(mauSac);
        chiTietSanPham.setSize(siZe);
        chiTietSanPham.setSoLuong(Integer.parseInt(soluong));

        ChiTietSanPham chiTietSanPham1 = iChiTietSanPhamService.save(chiTietSanPham);

        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
