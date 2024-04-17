/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.XuLy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dat dep trai
 */
@Entity
@Table(name="xuly")
public class xuly implements Serializable {

    @Id
    private int MaXL;
    
    @Column(name="MaTV")
    private int MaTV;
    
    @Column(name="HinhThucXL")
    private String HinhThucXL;
    
    @Column(name="SoTien")
    private Integer SoTien;
    
    @Column(name="NgayXL")
    private String NgayXL;
    
    @Column(name="TrangThaiXL")
    private int TrangThaiXL;
    public xuly(){}
    public xuly(int MaXL,int MaTV ,String HinhThucXL, Integer SoTien, String NgayXL , int TrangThaiXL){
        this.MaXL = MaXL;
        this.MaTV = MaTV;
        this.HinhThucXL = HinhThucXL;
        this.SoTien = SoTien;
        this.NgayXL = NgayXL;
        this.TrangThaiXL = TrangThaiXL;
    }

    public int getMaXL() {
        return MaXL;
    }

    public void setMaXL(int MaXL) {
        this.MaXL = MaXL;
    }

    public int getMaTV() {
        return MaTV;
    }

    public void setMaTV(int MaTV) {
        this.MaTV = MaTV;
    }

    public String getHinhThucXL() {
        return HinhThucXL;
    }

    public void setHinhThucXL(String HinhThucXL) {
        this.HinhThucXL = HinhThucXL;
    }

    public Integer getSoTien() {
        return SoTien;
    }

    public void setSoTien(Integer SoTien) {
        this.SoTien = SoTien;
    }

    public String getNgayXL() {
        return NgayXL;
    }

    public void setNgayXL(String NgayXL) {
        this.NgayXL = NgayXL;
    }

    public int getTrangThaiXL() {
        return TrangThaiXL;
    }

    public void setTrangThaiXL(int TrangThaiXL) {
        this.TrangThaiXL = TrangThaiXL;
    }
    
    
}
