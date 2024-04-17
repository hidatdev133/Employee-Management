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

    public void addThanhVien(thanhvien tv) {
        thanhVienDAL.addThanhVien(tv);
    }

    public void updateThanhVien(thanhvien tv) {
        thanhVienDAL.updateThanhVien(tv);
    }

    public void deleteThanhVien(thanhvien tv) {
        thanhVienDAL.deleteThanhVien(tv);
    }

    public String getHoTenbyMaTV(int MaTV) {
        return thanhVienDAL.getHotenByMaTV(MaTV);
    }
}
