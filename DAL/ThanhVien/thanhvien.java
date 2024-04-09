/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.ThanhVien;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Entity
@Data
@Table(name = "thanhvien")
public class thanhvien {
    @Id
    private int MaTV;
    
    @Column
    private String HoTen;
    
    @Column
    private String Khoa;
    
    @Column
    private String Nganh;
    
    @Column
    private int SDT;
    
    @Column
    private String Password;
    
    @Column
    private String Email;

    public thanhvien() {
    }

    public thanhvien(int MaTV, String HoTen, String Khoa, String Nganh, int SDT, String Password, String Email) {
        this.MaTV = MaTV;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
        this.Password = Password;
        this.Email = Email;
    }


    
}
