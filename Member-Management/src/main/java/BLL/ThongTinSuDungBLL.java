package BLL;

import DAL.ThanhVien.ThanhVienDAL;
import DAL.ThongTinSuDung.ThongTinSuDungDAL;
import DAL.ThongTinSuDung.thongtinsd;

public class ThongTinSuDungBLL {
    private ThongTinSuDungDAL ttsdDAL;

    public ThongTinSuDungBLL() {
        ttsdDAL = new ThongTinSuDungDAL();
    }
    
    public boolean addThongTinSdTB(thongtinsd ttsd) {
        return ttsdDAL.addThongTinSdTB(ttsd);
    }
    
    public boolean addThongTinVao(thongtinsd ttsd) {
        return ttsdDAL.addThongTinVao(ttsd);
    }
    
    public boolean updateThongTinSd(thongtinsd ttsd) {
        return ttsdDAL.updateThongTinSd(ttsd);
    }
    
    public int getmaxMaTT(){
        return ttsdDAL.getMaxMaTT();
    }
    
    public thongtinsd getThongTinSdDangMuon(int matv, int matb) {
        return ttsdDAL.getThongTinSdDangMuon(matv, matb);
    }
    
    public boolean isThietBiDangDcMuon(int matb) {
        return ttsdDAL.isThietBiDangDcMuon(matb);
    }
}
