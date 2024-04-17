package DAL.ThanhVien;

import DAL.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class ThanhVienDAL {

    Session session;

    public ThanhVienDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public int getTotalCount() {
        List<thanhvien> thanhVienList = getAllThanhVien(); // Assuming loadThanhVien() returns the list of all members
        return thanhVienList.size();
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

    public List<String> loadcbMatv() {
        List<String> TV = new ArrayList<>();
        try {
            session.beginTransaction();
            // Sử dụng hàm SELECT trong HQL để chỉ lấy MaTV từ bảng thanhvien
            List<Integer> maTVList = session.createQuery("SELECT MaTV FROM thanhvien ORDER BY MaTV ASC", Integer.class).list();
            session.getTransaction().commit();

            // Chuyển đổi danh sách Integer sang danh sách String
            for (Integer maTV : maTVList) {
                TV.add(String.valueOf(maTV));
            }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return TV;
    }

    public thanhvien getThanhVien(int MaTV) {
        thanhvien tv = session.get(thanhvien.class, MaTV);
        return tv;
    }


//    public void addThanhVien(thanhvien tv) {
//        session.beginTransaction();
//        session.save(tv);
//        session.getTransaction().commit();
//        session.clear();
//    }
//
//    public void updateThanhVien(thanhvien tv) {
//        session.beginTransaction();
//        session.saveOrUpdate(tv);
//        session.getTransaction().commit();
//    }
//
//    public void deleteThanhVien(thanhvien tv) {
//        session.delete(tv);

    
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

    public String getHotenByMaTV(int MaTV) {
        String hoten = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT t.HoTen FROM thanhvien t WHERE t.MaTV = :MaTV");
            query.setParameter("MaTV", MaTV);
            hoten = (String) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return hoten;
    }
}
