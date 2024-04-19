package DAL.ThongTinSuDung;

import DAL.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ThongTinSuDungDAL {
    Session session;
    
    public ThongTinSuDungDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public boolean addThongTinVao(thongtinsd ttsd) {
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("INSERT INTO thongtinsd (MaTT, MaTV, TGVao) VALUES (:matt, :matv, :tgvao)")
                    .setParameter("matt", ttsd.getMaTT())
                    .setParameter("matv", ttsd.getMaTV())
                    .setParameter("tgvao", ttsd.getTGVao());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addThongTinSdTB(thongtinsd ttsd) {
        try {
            session.beginTransaction();
            session.save(ttsd);
            session.getTransaction().commit();
            session.clear();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean updateThongTinSd(thongtinsd ttsd) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(ttsd);
            session.getTransaction().commit();
            session.clear();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public thongtinsd getThongTinSdDangMuon(int matv, int matb) {
        thongtinsd ttsd = null;
        try { 
            Query query = session.createSQLQuery("SELECT * FROM thongtinsd WHERE MaTV = :matv AND MaTB = :matb AND TGTra IS NULL")
                    .addEntity(thongtinsd.class)
                    .setParameter("matv", matv)
                    .setParameter("matb", matb);
            if (query.list().size() > 0) {
                ttsd = (thongtinsd) query.getSingleResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ttsd;
    }
    
    public boolean isThietBiDangDcMuon(int matb) {
        boolean result = false;
        try {
            Query query = session.createSQLQuery("SELECT * FROM thongtinsd WHERE MaTB = :matb AND TGMuon IS NOT NULL AND TGTra IS NULL")
                    .addEntity(thongtinsd.class)
                    .setParameter("matb", matb);
            if (query.list().size() > 0) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }
    
    public int getMaxMaTT() {
        int maxMaTT = 0;
        try {
            session.beginTransaction();
            // Sử dụng truy vấn SQL để lấy giá trị lớn nhất của trường MaTV
            Query query = session.createSQLQuery("SELECT MAX(MaTT) FROM thongtinsd");
            // Ép kiểu kết quả về kiểu int
            maxMaTT = (Integer) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        // Tăng giá trị mã TV lớn nhất lên 1
        return maxMaTT + 1;
    }
}
