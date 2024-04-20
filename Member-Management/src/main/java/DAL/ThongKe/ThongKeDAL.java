/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.ThongKe;

import DAL.HibernateUtils;
import DAL.ThanhVien.thanhvien;
import DAL.ThietBi.thietbi;
import DAL.ThongTinSuDung.thongtinsd;
import DAL.XuLy.xuly;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

        
    public List<thongtinsd> getTimeMember(String from ,  String to ){
        List<thongtinsd> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thongtinsd WHERE TGVao >= '" + from + "' AND TGMuon != '0000-00-00 00:00:00' ", thongtinsd.class).list();
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
     
    public List<thongtinsd> getListBorrowed(String from, String to){
        List<thongtinsd> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("FROM thongtinsd WHERE TGMuon >= '" + from + "' AND TGMuon <= '" + to + "' AND TGMuon != '0000-00-00 00:00:00'",thongtinsd.class).list();
            session.getTransaction().commit();
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
    
    public List<thongtinsd> getTopBorrowed(){
         List<thongtinsd> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery(" FROM thongtinsd WHERE TGMuon != '0000-00-00 00:00:00' GROUP BY MaTB ORDER BY COUNT(MaTB) DESC", thongtinsd.class).list();
            session.getTransaction().commit();
           
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
    
    
     public thietbi getThietBi(int MaTV) {
        thietbi tb = session.get(thietbi.class, MaTV);
        return tb;
    }
     
    public List<xuly> getListPunish(){
        List<xuly> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery(" FROM xuly WHERE TrangThaiXL = 0 GROUP BY MaTV ", xuly.class).list();
            session.getTransaction().commit();
           
            session.clear();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return list;
    }
    
     public int getTotalCount() {
        List<thietbi> thietBiList = loadThietbi();
        return thietBiList.size();
    }
    
    public List loadThietbi() {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<thietbi> tb = null;
        try {
            transaction = session.beginTransaction();
            tb = session.createQuery("FROM thietbi", thietbi.class).list();
            transaction.commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return tb;
    }
}
