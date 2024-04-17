package DAL.XuLy;

import DAL.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Dat dep trai
 */
public class XuLyDAL {
    Session session;
    
    public XuLyDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public int getTotalCount() {
        List<xuly> xulyList = loadXuLy(); 
        return xulyList.size();
    }
    
    public List loadXuLy() {
        List<xuly> xl = null;
        try {
            session.beginTransaction();
            // Sử dụng COALESCE để trả về giá trị rỗng nếu SoTien là null
            xl = session.createQuery("SELECT new xuly( x.MaXL, x.MaTV, x.HinhThucXL, COALESCE(x.SoTien, 0.0), x.NgayXL, x.TrangThaiXL) FROM xuly x", xuly.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return xl;
    }
    
    public List<String> loadcbMaxl() {
      List<String> xl = new ArrayList<>();
      try {
          session.beginTransaction();
          // Sử dụng hàm SELECT trong HQL để chỉ lấy MaXL
          List<Integer> maXlList = session.createQuery("SELECT MaXL FROM xuly ORDER BY MaXL ASC", Integer.class).list();
          session.getTransaction().commit();

          // Chuyển đổi danh sách Integer sang danh sách String
          for (Integer maXl : maXlList) {
              xl.add(String.valueOf(maXl));
          }
      } catch (Exception ex) {
          session.getTransaction().rollback();
          ex.printStackTrace();
      }
      return xl;
    }
    
    

    public xuly getXulyByMaXL(int MaXL) {
        xuly xuly = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT new xuly(x.MaXL, x.MaTV, x.HinhThucXL, COALESCE(x.SoTien, 0.0), x.NgayXL, x.TrangThaiXL) FROM xuly x WHERE x.MaXL = :MaXL", xuly.class);
            query.setParameter("MaXL", MaXL);
            xuly = (xuly) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return xuly;
    }

    
    public boolean matvExistsInXulyWithTrangthaixl0(int matv) {
        try {
            Query query = session.createQuery("SELECT COUNT(*) FROM xuly WHERE MaTV = :matv AND TrangThaiXL = 0");
            query.setParameter("matv", matv);
            long count = (long) query.uniqueResult();
            return count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; // Return false in case of any exception or error
        }
    }
    
    public boolean addXuly(xuly newXuly) {
        try {
            session.beginTransaction();

            // Check if Matv already exists in xuly with trangthaixl equal to 0
            if (!matvExistsInXulyWithTrangthaixl0(newXuly.getMaTV())) {
                // Matv does not exist in xuly with trangthaixl equal to 0, proceed with adding newXuly
                session.save(newXuly);
                session.getTransaction().commit();
                return true;
            } else {
                // Matv already exists with trangthaixl equal to 0, do not add
                // Display an error message or handle it accordingly
                System.err.println("Cannot add newXuly. Matv already exists in xuly with trangthaixl = 0.");
                session.getTransaction().rollback();
                return false;
            }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return false;
}

    
    public int getMaxMaTV() {
        int maxMaTV = 0;
        try {
            session.beginTransaction();
            // Sử dụng truy vấn SQL để lấy giá trị lớn nhất của trường MaTV
            Query query = session.createSQLQuery("SELECT MAX(MaXL) FROM xuly");
            // Ép kiểu kết quả về kiểu int
            maxMaTV = (Integer) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        // Tăng giá trị mã TV lớn nhất lên 1
        return maxMaTV + 1;
    }
    
    @Transactional
    public boolean deleteXulyByMaXL(int MaXL) {
        try {
            // Lấy đối tượng xuly cần xóa dựa trên mã xử lý
            xuly xulyToDelete = session.get(xuly.class, MaXL);
            if (xulyToDelete != null) {
                // Xóa đối tượng nếu nó tồn tại
                session.delete(xulyToDelete);
                System.out.println("Đã xóa xuly có MaXL: " + MaXL);
                return true;
            } else {
                System.out.println("Không tìm thấy xuly có MaXL: " + MaXL + ". Không có gì để xóa.");
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateXuly(xuly updatedXuly) {
        try {
            session.beginTransaction();
            // Lấy đối tượng xuly cần cập nhật từ cơ sở dữ liệu
            xuly existingXuly = session.get(xuly.class, updatedXuly.getMaXL());

                
                existingXuly.setHinhThucXL(updatedXuly.getHinhThucXL());
                existingXuly.setSoTien(updatedXuly.getSoTien());
                existingXuly.setNgayXL(updatedXuly.getNgayXL());
                
                if(!matvExistsInXulyWithTrangthaixl0(existingXuly.getMaTV())){
                existingXuly.setMaTV(updatedXuly.getMaTV());
                existingXuly.setTrangThaiXL(updatedXuly.getTrangThaiXL());
                        session.update(existingXuly);
                        session.getTransaction().commit();
                        System.out.println("Đã cập nhật xuly có MaXL: " + updatedXuly.getMaXL());
                        return true;
                    }
                    else{
                        return false;
                    }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
        
       
    }
     public List<xuly> getXulyBySimilarMatv(String MaTV) {
        List<xuly> xulyList = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM xuly WHERE CAST(MaTV AS string) LIKE :MaTV", xuly.class);
            query.setParameter("MaTV", "%" + MaTV + "%");
            xulyList = query.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return xulyList;
    }
     
    public List<xuly> getXulyBySimilarMaxl(String Maxl) {
        List<xuly> xulyList = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM xuly WHERE CAST(MaXL AS string) LIKE :MaXL", xuly.class);
            query.setParameter("MaXL", "%" + Maxl + "%");
            xulyList = query.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        return xulyList;
    }
}
        
    
    
    