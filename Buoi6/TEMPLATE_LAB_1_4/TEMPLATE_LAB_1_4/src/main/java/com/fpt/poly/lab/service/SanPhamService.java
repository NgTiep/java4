package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    void deleteSanPham(List<SanPham> list, int id);

    SanPham detailSanPham(List<SanPham> list, int id);

    int viTriUpdate(List<SanPham> list, int id);

    SanPham updateSanPham(List<SanPham> list, int id);

    List<SanPham> sortSanPham(List<SanPham> list);

    List<SanPham> searchTen(List<SanPham> list, String ten);

    List<SanPham> sanPhamCai(List<SanPham> list, boolean gioiTinh);

    List<SanPham> loaiSanPham(List<SanPham> list, String loai);

}
