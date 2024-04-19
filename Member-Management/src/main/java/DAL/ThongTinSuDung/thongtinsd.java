package DAL.ThongTinSuDung;

import DAL.ThietBi.thietbi;
import java.time.LocalDateTime;
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
    private LocalDateTime TGVao;
    @Column
    private LocalDateTime TGMuon;
    @Column
    private LocalDateTime TGTra;

    public thongtinsd() {
    }

    public thongtinsd(int MaTT, int MaTV, int MaTB, LocalDateTime TGVao, LocalDateTime TGMuon, LocalDateTime TGTra) {
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

    public LocalDateTime getTGVao() {
        return TGVao;
    }

    public void setTGVao(LocalDateTime TGVao) {
        this.TGVao = TGVao;
    }

    public LocalDateTime getTGMuon() {
        return TGMuon;
    }

    public void setTGMuon(LocalDateTime TGMuon) {
        this.TGMuon = TGMuon;
    }

    public LocalDateTime getTGTra() {
        return TGTra;
    }

    public void setTGTra(LocalDateTime TGTra) {
        this.TGTra = TGTra;
    }

    @ManyToOne
    @JoinColumn(name = "MaTB", insertable = false, updatable = false)
    private thietbi tb;

}
