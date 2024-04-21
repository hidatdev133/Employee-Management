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
    
    public List<thanhvien> searchThanhVien(String keyword, int condition) {
        List<thanhvien> tvList = new ArrayList<>();
        try {
            session.beginTransaction();
            String hql = "";
            switch (condition) {
                case 1:
                    hql = "from thanhvien where CAST(MaTV AS string) like :keyword";
                    break;
                case 2:
                    hql = "from thanhvien where HoTen like :keyword";
                    break;
                case 3:
                    hql = "from thanhvien where Khoa like :keyword";
                    break;
                case 4:
                    hql = "from thanhvien where Nganh like :keyword";
                    break;
                case 5:
                    hql = "from thanhvien where CAST(SDT AS string) like :keyword";
                    break;
                case 6:
                    hql = "from thanhvien where Email like :keyword";
                    break;
                default:
                    break;
            }
            
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            tvList = query.list();

            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return tvList;
    }
}
