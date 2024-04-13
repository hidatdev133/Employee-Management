package BLL;

import DAL.ThietBi.thietbi;
import DAL.ThietBi.thietbiDAL;
import java.util.List;

public class thietbiBLL {

    private thietbiDAL tbDAL;
    private boolean isSuccess = false;

    public thietbiBLL() {
        this.tbDAL = new thietbiDAL();
    }

    public List loadThietbi() {
        List list = tbDAL.loadThietbi();
        return list;
    }

    public void addThietbi(thietbi tb) {
        // Thực hiện thêm thiết bị
        try {
            tbDAL.addThietbi(tb); // Gọi phương thức thêm thiết bị từ DAL
            isSuccess = true; // Gán true cho biến isSuccess nếu không có ngoại lệ nào xảy ra
        } catch (Exception e) {
            isSuccess = false; // Nếu có ngoại lệ, gán false cho biến isSuccess
            e.printStackTrace(); // In thông báo lỗi (nếu cần)
        }
    }

    public boolean isMaTbExisted(int maTb){
        return tbDAL.isMaTbExisted(maTb);
    }
    
    public void updateThietbi(thietbi tb) {
        try {
            tbDAL.updateThietbi(tb); // Gọi phương thức thêm thiết bị từ DAL
            isSuccess = true; // Gán true cho biến isSuccess nếu không có ngoại lệ nào xảy ra
        } catch (Exception e) {
            isSuccess = false; // Nếu có ngoại lệ, gán false cho biến isSuccess
            e.printStackTrace(); // In thông báo lỗi (nếu cần)
        }
    }

    public boolean deleteThietbi(int maTb) {
        return tbDAL.deleteThietbi(maTb); // Gọi phương thức thêm thiết bị từ DAL
    }
    
    public boolean deleteThietbiByMaQuyDinh(int maQuyDinh){
        return tbDAL.deleteThietbiByMaQuyDinh(maQuyDinh);
    }

    public boolean isSuccess() {
        return isSuccess;
    }
    
    public List<thietbi> searchThietBiByIDBLL(int maTb){
        return tbDAL.searchThietBiByIDDAL(maTb);
    }
    public List<thietbi> searchThietBiByNameBLL(String name){
        return tbDAL.searchThietBiByNameDAL(name);
    }
    public List<thietbi> searchThietBiByDescriptionBLL(String mota){
        return tbDAL.searchThietBiByDescriptionDAL(mota);
    }
}
