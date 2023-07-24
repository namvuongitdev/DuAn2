package com.example.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHang {
    @Id
    @Column(name = "Id")
    private String id;

    @NotBlank(message = "Họ tên không được để trống")
    @Column(name = "HoTen")
    private String hoTen;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Column(name = "Email")
    private String email;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @NotBlank(message = "Tên tài khoàn không được để trống")
    @Column(name = "TenTaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "SoDienThoai")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

}
