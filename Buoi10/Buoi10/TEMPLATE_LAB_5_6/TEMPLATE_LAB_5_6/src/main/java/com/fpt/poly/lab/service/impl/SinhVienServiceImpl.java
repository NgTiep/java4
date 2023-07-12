package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.repository.SinhVienRepository;
import com.fpt.poly.lab.service.SinhVienService;

import java.util.List;
import java.util.UUID;

public class SinhVienServiceImpl implements SinhVienService {
    private SinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    public List<SinhVien> getAll() {
        return sinhVienRepository.getAll();
    }

    @Override
    public SinhVien getOne(UUID ma) {
        return sinhVienRepository.getOne(ma);
    }

    @Override
    public List<SinhVien> search(String ten) {
        return sinhVienRepository.search(ten);
    }

    @Override
    public String add(SinhVien sinhVien) {
        boolean add = sinhVienRepository.add(sinhVien);
        if(add){
            return "add thanh cong";
        }else{
            return "add that bai";
        }
    }

    @Override
    public String update(SinhVien sinhVien) {
        boolean update = sinhVienRepository.update(sinhVien);
        if(update){
            return "update thanh cong";
        }else{
            return "update that bai";
        }
    }

    @Override
    public String delete(SinhVien sinhVien) {
        boolean delete = sinhVienRepository.delete(sinhVien);
        if(delete){
            return "delete thanh cong";
        }else{
            return "delete that bai";
        }
    }
}
