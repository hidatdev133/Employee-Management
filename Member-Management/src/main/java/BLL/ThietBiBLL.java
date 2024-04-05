package BLL;

import DAL.ThietBi.thietbi;
import DAL.ThietBi.thietbiDAL;
import java.util.List;

public class thietbiBLL {

    private thietbiDAL tbDAL;
    private boolean isSuccess;

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

    public void updateThietbi(thietbi tb) {
        try {
            tbDAL.updateThietbi(tb); // Gọi phương thức thêm thiết bị từ DAL
            isSuccess = true; // Gán true cho biến isSuccess nếu không có ngoại lệ nào xảy ra
        } catch (Exception e) {
            isSuccess = false; // Nếu có ngoại lệ, gán false cho biến isSuccess
            e.printStackTrace(); // In thông báo lỗi (nếu cần)
        }
    }

    public void deleteThietbi(thietbi tb) {
        try {
            tbDAL.deleteThietbi(tb); // Gọi phương thức thêm thiết bị từ DAL
            isSuccess = true; // Gán true cho biến isSuccess nếu không có ngoại lệ nào xảy ra
        } catch (Exception e) {
            isSuccess = false; // Nếu có ngoại lệ, gán false cho biến isSuccess
            e.printStackTrace(); // In thông báo lỗi (nếu cần)
        }
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
