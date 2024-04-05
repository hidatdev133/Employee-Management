package BLL;

import DAL.ThietBi.thietbi;
import DAL.ThietBi.thietbiDAL;
import java.util.List;

public class thietbiBLL {

    private thietbiDAL tbDAL;

    public thietbiBLL() {
        this.tbDAL = new thietbiDAL();
    }

    public List loadThietbi() {
        List list = tbDAL.loadThietbi();
        return list;
    }

    public void addThietbi(thietbi tb) {
        tbDAL.addThietbi(tb);
    }

    public void updateThietbi(thietbi tb) {
        tbDAL.updateThietbi(tb);
    }

    public void deleteThietbi(thietbi tb) {
        tbDAL.deleteThietbi(tb);
    }

}
