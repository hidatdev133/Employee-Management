/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.ThanhVien;

import DAL.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ThanhVienDAL {
    Session session;
    
    public ThanhVienDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<thanhvien> getAllThanhVien() {
        List<thanhvien> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thanhvien", thanhvien.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
    
    public thanhvien getThanhVien(int MaTV) {
        thanhvien tv = session.get(thanhvien.class, MaTV);
        return tv;
    }
    
    public boolean addThanhVien(thanhvien tv) {
        try {
            session.beginTransaction();
            session.save(tv);
            session.getTransaction().commit();
            session.clear();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateThanhVien(thanhvien tv) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(tv);
            session.getTransaction().commit();
            session.clear();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteThanhVien(thanhvien tv) {
        try {
            session.beginTransaction();
            session.delete(tv);
            session.getTransaction().commit();
            session.clear();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isMaTVExisted(int matv) {
        thanhvien tv = session.get(thanhvien.class, matv);
        return tv != null;
    }
}

