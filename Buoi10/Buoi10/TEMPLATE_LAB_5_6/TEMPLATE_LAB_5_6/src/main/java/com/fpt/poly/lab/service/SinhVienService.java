package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.SinhVien;

import java.util.List;
import java.util.UUID;

public interface SinhVienService {
    List<SinhVien> getAll();

    SinhVien getOne(UUID ma);

    List<SinhVien> search(String ten);

    String add(SinhVien sinhVien);

    String update(SinhVien sinhVien);

    String delete(SinhVien sinhVien);
}
