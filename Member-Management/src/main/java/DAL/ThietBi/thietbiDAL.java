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

    public boolean deleteThietbi(int maTb) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;
        try {
            transaction = session.beginTransaction();
            
            // Kiểm tra nếu có thông tin sử dụng liên kết với thời gian trả khác null thì không xóa
            String nativeQuery = "DELETE FROM thietbi WHERE MaTB = :maTB AND MaTB IN "
                    + "(SELECT MaTB FROM thongtinsd WHERE TGTra IS NOT NULL OR "
                    + "TGTra <> '0000-00-00 00:00:00')";
            NativeQuery<?> query = session.createSQLQuery(nativeQuery);
            query.setParameter("maTB", maTb);
            int rowsAffected = query.executeUpdate();
            
            if (rowsAffected > 0) {
                success = true;
            } else {
                System.out.println("Không tìm thấy hoặc không thể xóa thiết bị có mã " + maTb);
            }
            
//            thietbi tb = session.get(thietbi.class, maTb);
//            session.delete(tb);
            transaction.commit();
            
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            success = false;
        }
        return success;
    }
    
    public boolean deleteThietbiByPrefix(int keyword) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<thietbi> thietbiList = new ArrayList<>();
        boolean success = false;
        try {
            transaction = session.beginTransaction();
            
            
            // Sử dụng HQL để thực hiện truy vấn
            String hql = "FROM thietbi WHERE matb = :keyword AND matb IN "
                    + "(SELECT matb FROM thongtinsd WHERE TGTra IS NOT NULL OR "
                    + "TGTra <> '0000-00-00 00:00:00')";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%"); // Sử dụng tham số để tránh SQL Injection

            thietbiList = query.list();

            for(thietbi tb : thietbiList) {
                System.out.println("Device Code: " + tb.getMaTB());
            }
            
            
            
//            thietbi tb = session.get(thietbi.class, maTb);
//            session.delete(tb);
            transaction.commit();
            
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            success = false;
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
}
