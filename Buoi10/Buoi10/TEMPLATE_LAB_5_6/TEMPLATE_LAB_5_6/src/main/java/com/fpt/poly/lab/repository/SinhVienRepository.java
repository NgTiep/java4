package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SinhVienRepository {
    public List<SinhVien> getAll() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien ", SinhVien.class);
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSinhVien;
    }

    public SinhVien getOne(UUID ma) {
        SinhVien sinhVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien WHERE ma=:ma", SinhVien.class);
            query.setParameter("ma", ma);
            sinhVien = (SinhVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sinhVien;
    }

    public List<SinhVien> search(String ten) {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien WHERE ten like :ten", SinhVien.class);
            query.setParameter("ten", "%" + ten + "%");
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSinhVien;
    }

    public Boolean add(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


}
