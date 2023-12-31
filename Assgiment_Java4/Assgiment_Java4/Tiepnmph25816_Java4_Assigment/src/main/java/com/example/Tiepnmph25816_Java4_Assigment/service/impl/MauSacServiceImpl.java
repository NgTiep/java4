package com.example.Tiepnmph25816_Java4_Assigment.service.impl;

import com.example.Tiepnmph25816_Java4_Assigment.entity.MauSac;
import com.example.Tiepnmph25816_Java4_Assigment.repository.MauSacRepository;
import com.example.Tiepnmph25816_Java4_Assigment.service.MauSacService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public MauSac getOne(UUID id) {
        return mauSacRepository.getOne(id);
    }

    @Override
    public String add(MauSac mauSac) {
        if(mauSac.getMa().isEmpty() || mauSac.getTen().isEmpty()){
            return "Nhập đầy đủ thông tin";
        }else{
            boolean add = mauSacRepository.add(mauSac);
            if (add) {
                return "add thanh cong";
            } else {
                return "add that bai";
            }
        }

    }

    @Override
    public String update(MauSac mauSac) {
        boolean update = mauSacRepository.update(mauSac);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(MauSac mauSac) {
        boolean delete = mauSacRepository.delete(mauSac);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
