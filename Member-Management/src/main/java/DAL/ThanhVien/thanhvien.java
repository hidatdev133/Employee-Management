package DAL.ThanhVien;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "thanhvien")
public class thanhvien {

    @Id
    private int MaTV;

    @Column
    private String ho_ten;

    @Column
    private String Khoa;

    @Column
    private String Nganh;

    @Column
    private int SDT;

    @Column
    private String pass_word;

    @Column
    private String Email;

    public thanhvien() {
    }

    public thanhvien(int MaTV, String ho_ten, String Khoa, String Nganh, int SDT, String pass_word, String Email) {
        this.MaTV = MaTV;
        this.ho_ten = ho_ten;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
        this.pass_word = pass_word;
        this.Email = Email;
    }

}