/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien.thanhvien;
import DAL.ThongKe.ThongKeDAL;
import DAL.ThongTinSuDung.thongtinsd;
import DAL.XuLy.xuly;
import java.util.Date;
import java.util.List;

/**
 *
 * @author trant
 */
public class ThongKeBLL {
    
    public ThongKeDAL tkDAL = new ThongKeDAL();
    
    
    public List<thanhvien> getAllThanhVien() {
        List<thanhvien> list = tkDAL.getAllThanhVien();
        return list;
    }
    
    public List<thongtinsd> getBorrowingMember() {
        List<thongtinsd> list = tkDAL.getBorrowingMember();
    return list;
    }

    public List<xuly> getPunishedMember() {
        List<xuly> list = tkDAL.getPunishedMember();
    return list;
    }
        
    public List<thongtinsd> getTimeMember(String from , String to) {
        List<thongtinsd> list = tkDAL.getTimeMember(from, to);
    return list;
    }

     public thanhvien getThanhVien(int MaTV) {
        return tkDAL.getThanhVien(MaTV);
    }
    
     public List<thanhvien> getDepartmentMember(String depart) {
        List<thanhvien> list = tkDAL.getDepartmentMember(depart);
        return list;
    }
     
    public List<thanhvien> getMajortMember(String major) {
        List<thanhvien> list = tkDAL.getMajorMember(major);
        return list;
    }
     
    public List<thanhvien> getListKhoa() {
        List<thanhvien> list = tkDAL.getListDepartment();
        return list;
    }
    
     public List<thanhvien> getListNganh() {
        List<thanhvien> list = tkDAL.getListMajor();
        return list;
    }
}
