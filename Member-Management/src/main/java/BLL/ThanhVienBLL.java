package BLL;

import DAL.ThanhVien.thanhvien;
import DAL.ThanhVien.ThanhVienDAL;
import java.util.List;

public class ThanhVienBLL {

    private ThanhVienDAL thanhVienDAL;

    public ThanhVienBLL() {
        thanhVienDAL = new ThanhVienDAL();
    }

    public List<thanhvien> getAllThanhVien() {
        List<thanhvien> list = thanhVienDAL.getAllThanhVien();
        return list;
    }

    public List<String> getAllMaTV() {
        return thanhVienDAL.loadcbMatv();
    }

    public thanhvien getThanhVien(int MaTV) {
        return thanhVienDAL.getThanhVien(MaTV);
    }
    
    public boolean addThanhVien(thanhvien tv) {
        return thanhVienDAL.addThanhVien(tv);
    }
    
    public boolean updateThanhVien(thanhvien tv) {
        return thanhVienDAL.updateThanhVien(tv);
    }
    
    public boolean deleteThanhVien(thanhvien tv) {
        return thanhVienDAL.deleteThanhVien(tv);
    }

    public String getHoTenbyMaTV(int MaTV) {
        return thanhVienDAL.getHotenByMaTV(MaTV);
    }
    
    public List<thanhvien> searchThanhVien(String keyword, int condition) {
        return thanhVienDAL.searchThanhVien(keyword, condition);
    }
}
