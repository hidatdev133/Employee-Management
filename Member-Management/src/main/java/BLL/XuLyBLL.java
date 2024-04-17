package BLL;

import DAL.XuLy.XuLyDAL;
import DAL.XuLy.xuly;
import java.util.List;

public class XuLyBLL {
    private XuLyDAL xlDAL;

    public XuLyBLL() {
        this.xlDAL = new XuLyDAL();
    }

    public List loadXuLy() {
        List list = xlDAL.loadXuLy();
        return list;
    }
    
    public List<String> loadcbMaxl() {
        return xlDAL.loadcbMaxl();
    }
    
    public xuly getXulybyMaxl(int MaXl){
        return xlDAL.getXulyByMaXL(MaXl);
    }
    
    public List<xuly> getXulyBySimilarMaxl(String MaXL){
        return xlDAL.getXulyBySimilarMaxl(MaXL);
    }
    
    public List<xuly> getXulyBySimilarMatv(String MaTV){
        return xlDAL.getXulyBySimilarMatv(MaTV);
    }
    
    public boolean themXuLy(xuly newXuly) {
        return xlDAL.addXuly(newXuly);
    }
    
    public int getmaxMaXL(){
        return xlDAL.getMaxMaTV();
    }
    
    public boolean xoaXuly(int Maxl){
       return xlDAL.deleteXulyByMaXL(Maxl);
    }
    
    public boolean capnhatXuly(xuly newxuly){
       return xlDAL.updateXuly(newxuly);
    }
    
}
