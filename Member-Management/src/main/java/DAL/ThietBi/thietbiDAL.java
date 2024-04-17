package DAL.ThietBi;

import DAL.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class thietbiDAL {

    Session session;

    public thietbiDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
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

    public thietbi getThietbi(int matb) {
        session = HibernateUtils.getSessionFactory().openSession();
        thietbi tb = session.get(thietbi.class, matb);
        return tb;
    }

    public void addThietbi(thietbi tb) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(tb);
            transaction.commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public boolean isMaTbExisted(int maTB) {
        session = HibernateUtils.getSessionFactory().openSession();
        thietbi tb = session.get(thietbi.class, maTB);
        return tb != null;
    }

    public void updateThietbi(thietbi tb) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(tb);
            transaction.commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public boolean deleteThietBiByIDDAL(int maTb) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;
        try {
            transaction = session.beginTransaction();

            // Tìm các mã thiết bị cần xóa dựa trên từ khóa
            String hqlSelect = "SELECT tb.MaTB FROM thietbi tb WHERE CAST(tb.MaTB AS string) LIKE :keyword "
                    + "AND (tb.MaTB NOT IN (SELECT ttsd.MaTB FROM thongtinsd ttsd WHERE "
                    + "ttsd.MaTB = tb.MaTB AND (ttsd.TGTra IS NULL OR ttsd.TGTra = '0000-00-00 00:00:00')) "
                    + "OR NOT EXISTS (SELECT 1 FROM thongtinsd ttsd WHERE ttsd.MaTB = tb.MaTB))";
            Query querySelect = session.createQuery(hqlSelect);
            querySelect.setParameter("keyword", maTb + "");
            List<String> maTBexist = querySelect.list();

            // Tạo câu lệnh SQL DELETE
            String sqlDelete = "DELETE FROM thietbi WHERE MaTB IN (:maTBexist)";
            Query queryDelete = session.createSQLQuery(sqlDelete);
            queryDelete.setParameterList("maTBexist", maTBexist);
            int rowCount = queryDelete.executeUpdate();
            
            if(rowCount > 0){
                success = true;
            }else{
                success = false;
            }

            transaction.commit();
            success = true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    public boolean deleteThietBiByMaQuyDinhDAL(int maQuyDinh) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;
        try {
            transaction = session.beginTransaction();

            // Tìm các mã thiết bị cần xóa dựa trên từ khóa
            String hqlSelect = "SELECT tb.MaTB FROM thietbi tb WHERE CAST(tb.MaTB AS string) LIKE :keyword "
                    + "AND (tb.MaTB NOT IN (SELECT ttsd.MaTB FROM thongtinsd ttsd WHERE "
                    + "ttsd.MaTB = tb.MaTB AND (ttsd.TGTra IS NULL OR ttsd.TGTra = '0000-00-00 00:00:00')) "
                    + "OR NOT EXISTS (SELECT 1 FROM thongtinsd ttsd WHERE ttsd.MaTB = tb.MaTB))";
            Query querySelect = session.createQuery(hqlSelect);
            querySelect.setParameter("keyword", maQuyDinh + "%");
            List<String> maTBList = querySelect.list();

            // Tạo câu lệnh SQL DELETE
            String sqlDelete = "DELETE FROM thietbi WHERE MaTB IN (:maTBList)";
            Query queryDelete = session.createSQLQuery(sqlDelete);
            queryDelete.setParameterList("maTBList", maTBList);
            int rowCount = queryDelete.executeUpdate();

            transaction.commit();
            success = true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    public List<thietbi> searchThietBiByIDDAL(int maTb){
        int keyword = maTb; // Chuỗi bạn nhập vào
        List<thietbi> thietbiList = new ArrayList<>();
        
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Sử dụng HQL để thực hiện truy vấn
            String hql = "from thietbi where matb like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%"); // Sử dụng tham số để tránh SQL Injection

            thietbiList = query.list();

            for(thietbi tb : thietbiList) {
                System.out.println("Device Code: " + tb.getMaTB());
            }

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return thietbiList;
    }
    
    
    public List<thietbi> searchThietBiByNameDAL(String name){
        String keyword = name; // Chuỗi bạn nhập vào
        List<thietbi> thietbiList = new ArrayList<>();
        
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Sử dụng HQL để thực hiện truy vấn
            String hql = "from thietbi where tentb like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%"); // Sử dụng tham số để tránh SQL Injection

            thietbiList = query.list();

            for(thietbi tb : thietbiList) {
                System.out.println("Device Code: " + tb.getMaTB());
            }

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return thietbiList;
    }
    
    
    public List<thietbi> searchThietBiByDescriptionDAL(String des){
        String keyword = des; // Chuỗi bạn nhập vào
        List<thietbi> thietbiList = new ArrayList<>();
        
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Sử dụng HQL để thực hiện truy vấn
            String hql = "from thietbi where motatb like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");

            thietbiList = query.list();

            for(thietbi tb : thietbiList) {
                System.out.println("Device Code: " + tb.getMaTB());
            }

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return thietbiList;
    }
    
    
}
