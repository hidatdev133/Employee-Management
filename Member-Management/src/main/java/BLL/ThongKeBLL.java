/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien.thanhvien;
import DAL.ThietBi.thietbi;
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
     
    public List<thongtinsd> getListBorrowed(String from , String to){
        List<thongtinsd> list = tkDAL.getListBorrowed(from, to);
        return list ;
    }
    
    public thietbi getThietBi(int maTB){
        thietbi tb = tkDAL.getThietBi(maTB);
        return tb;
    }
    
    public List<thongtinsd> getTopBorrowed(){
        return tkDAL.getTopBorrowed();
    }
    
    public List<xuly> getListPunish(){
        return tkDAL.getListPunish();
    }
    
    public int getTotalThietBi(){
        return tkDAL.getTotalCount();
    }
  
            public List getTotalDaXL(){
        return tkDAL.getListXuLyDaXuLy();
    }
  public List getTotalChuaXL(){
      return tkDAL.getListChuaXuLy();
  }
  public thanhvien getTV(int ma){
      return tkDAL.getThanhVien(ma);
  }
  public List getXL(){
      return tkDAL.getXuLy();
              }
  public int getTongTien(){
      List <xuly>list=tkDAL.getListXuLyDaXuLy();
      int tong=0;
      for(xuly xl:list){
          if(xl.getSoTien()!=null){
              tong+=xl.getSoTien();
          }
      }
      return tong;
  }
  public List getthietbidangmuon(){
      return tkDAL.getThietBiDangMuon();
  }
   public thietbi getthietbi(int ma){
       return tkDAL.getthietbi(ma);
   }
   public long  getAmountCXL(String hinhthuc){
       return tkDAL.getAmountChuaXL(hinhthuc);
   }
   public long  getAmountXL(String hinhthuc){
       return tkDAL.getAmountViPham(hinhthuc);
   }
   public List getHinhThuc(){
       return tkDAL.getHinhThuc();
   }
   public List getThietBiThoiGian(String from, String to){
       return tkDAL.getThietBiTheoThoiGian(from, to);
   }
   public int getTongTB(){
       return tkDAL.getTB().size();
   }
}
