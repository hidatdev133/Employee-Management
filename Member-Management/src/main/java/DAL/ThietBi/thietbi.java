package DAL.ThietBi;

import DAL.ThongTinSuDung.thongtinsd;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
//import org.hibernate.mapping.Set;

@Entity
public class thietbi {
    @Id
    private int MaTB;
    @Column
    private String TenTB;
    @Column
    private String mo_tatb;

    public thietbi() {
    }

    public thietbi(int MaTB, String TenTB, String mo_tatb) {
        this.MaTB = MaTB;
        this.TenTB = TenTB;
        mo_tatb = mo_tatb;
    }

    public int getMaTB() {
        return MaTB;
    }

    public void setMaTB(int MaTB) {
        this.MaTB = MaTB;
    }

    public String getTenTB() {
        return TenTB;
    }

    public void setTenTB(String TenTB) {
        this.TenTB = TenTB;
    }

    public String getMo_tatb() {
        return mo_tatb;
    }

    public void setMo_tatb(String mo_tatb) {
        this.mo_tatb = mo_tatb;
    }

    public List<thongtinsd> getListTtsd() {
        return listTtsd;
    }

    public void setListTtsd(List<thongtinsd> listTtsd) {
        this.listTtsd = listTtsd;
    }
    
    @OneToMany(mappedBy = "tb", cascade = CascadeType.ALL)
    private List<thongtinsd> listTtsd;
    
}
