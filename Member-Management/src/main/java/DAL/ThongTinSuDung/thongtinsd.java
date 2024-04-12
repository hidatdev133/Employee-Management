package DAL.ThongTinSuDung;

import DAL.ThietBi.thietbi;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
public class thongtinsd {

    @Id
    private int MaTT;
    @Column
    private int MaTV;
    @Column
    private int MaTB;
    @Column
    private Date TGVao;
    @Column
    private Date TGMuon;
    @Column
    private Date TGTra;

    public thongtinsd() {
    }

    public thongtinsd(int MaTT, int MaTV, int MaTB, Date TGVao, Date TGMuon, Date TGTra) {
        this.MaTT = MaTT;
        this.MaTV = MaTV;
        this.MaTB = MaTB;
        this.TGVao = TGVao;
        this.TGMuon = TGMuon;
        this.TGTra = TGTra;
    }

    public int getMaTT() {
        return MaTT;
    }

    public void setMaTT(int MaTT) {
        this.MaTT = MaTT;
    }

    public int getMaTV() {
        return MaTV;
    }

    public void setMaTV(int MaTV) {
        this.MaTV = MaTV;
    }

    public int getMaTB() {
        return MaTB;
    }

    public void setMaTB(int MaTB) {
        this.MaTB = MaTB;
    }

    public Date getTGVao() {
        return TGVao;
    }

    public void setTGVao(Date TGVao) {
        this.TGVao = TGVao;
    }

    public Date getTGMuon() {
        return TGMuon;
    }

    public void setTGMuon(Date TGMuon) {
        this.TGMuon = TGMuon;
    }

    public Date getTGTra() {
        return TGTra;
    }

    public void setTGTra(Date TGTra) {
        this.TGTra = TGTra;
    }

    @ManyToOne
    @JoinColumn(name = "MaTB")
    private thietbi tb;

}
