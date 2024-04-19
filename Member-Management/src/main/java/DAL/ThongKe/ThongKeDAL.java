/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.ThongKe;

import DAL.HibernateUtils;
import DAL.ThanhVien.thanhvien;
import DAL.ThongTinSuDung.thongtinsd;
import DAL.XuLy.xuly;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author trant
 */
public class ThongKeDAL {
    
    Session session;

    public ThongKeDAL() {
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
    
    public List<thongtinsd> getBorrowingMember(){
        List<thongtinsd> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thongtinsd WHERE   TGMuon != '0000-00-00 00:00:00'  AND TGTra is null AND TGMuon is not null", thongtinsd.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
            
    }
    
    public List<xuly> getPunishedMember(){
        List<xuly> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM xuly WHERE TrangThaiXL = 1 ", xuly.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
            
    }
        
    public List<thongtinsd> getTimeMember(String from ,  String to ){
        List<thongtinsd> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thongtinsd WHERE TGVao >= '" + from + " 00:00:00' AND TGMuon != '0000-00-00 00:00:00' ", thongtinsd.class).list();
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
    
    public List<thanhvien> getDepartmentMember(String depart){
         List<thanhvien> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thanhvien WHERE Khoa = '" + depart + "' ", thanhvien.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
    
    public List<thanhvien> getMajorMember(String major){
         List<thanhvien> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thanhvien WHERE Nganh = '" + major + "' ", thanhvien.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
    
     public List<thanhvien> getListDepartment(){
         List<thanhvien> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery(" FROM thanhvien GROUP BY Khoa ", thanhvien.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
     
     public List<thanhvien> getListMajor(){
         List<thanhvien> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery(" FROM thanhvien GROUP BY Nganh ", thanhvien.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
}
