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
        session.beginTransaction();
        list = session.createQuery("FROM thanhvien", thanhvien.class).list();
        session.getTransaction().commit();
        session.clear();
        return list;
    }
    
    public thanhvien getThanhVien(int MaTV) {
        thanhvien tv = session.get(thanhvien.class, MaTV);
        return tv;
    }
    
    public void addThanhVien(thanhvien tv) {
        session.beginTransaction();
        session.save(tv);
        session.getTransaction().commit();
        session.clear();
    }
    
    public void updateThanhVien(thanhvien tv) {
        session.beginTransaction();
        session.saveOrUpdate(tv);
        session.getTransaction().commit();
    }
    
    public void deleteThanhVien(thanhvien tv) {
        session.delete(tv);
    }
    
    public boolean isMaTVExisted(int matv) {
        thanhvien tv = session.get(thanhvien.class, matv);
        return tv != null;
    }
}

