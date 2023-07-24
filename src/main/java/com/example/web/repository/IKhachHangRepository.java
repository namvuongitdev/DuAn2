package com.example.web.repository;

import com.example.web.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhachHangRepository extends JpaRepository<KhachHang, String> {
    @Query("SELECT c from KhachHang c where c.hoTen like "+"%"+"?1"+"%")
    List<KhachHang> searchByName(String name);

    @Query("SELECT c from KhachHang c where c.trangThai = ?1")
    List<KhachHang> searchByStatus(Integer status);

}
