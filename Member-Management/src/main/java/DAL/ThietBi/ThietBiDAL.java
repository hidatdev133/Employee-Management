package DAL.ThietBi;

import DAL.HibernateUtils;
import java.util.List;
import org.hibernate.Session;

public class thietbiDAL {

    Session session;

    public thietbiDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadThietbi() {
        List<thietbi> tb = null;
        try {
            session.beginTransaction();
            tb = session.createQuery("FROM thietbi", thietbi.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return tb;
    }

    public thietbi getThietbi(int matb) {
        thietbi tb = session.get(thietbi.class, matb);
        return tb;
    }

    public void addThietbi(thietbi tb) {
        try {
            session.beginTransaction();
            session.save(tb);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public boolean isMaTbExisted(int maTB) {
        thietbi tb = session.get(thietbi.class, maTB);
        return tb != null;
    }

    public void updateThietbi(thietbi tb) {
        try {
            session.beginTransaction();
            session.update(tb);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void deleteThietbi(thietbi tb) {
        try {
            session.beginTransaction();
            session.delete(tb);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
