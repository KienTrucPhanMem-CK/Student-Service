package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SinhVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVien {
    @Id
    @Column(name = "mssv")
    private long mssv;
    @Column(name = "matKhau", length = 32)
    private String matKhau;
    @Column(name = "hoTen", length = 100)
    private String hoTen;
    @Column(name = "ngaySinh")
    private LocalDateTime ngaySinh;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "queQuan")
    private String queQuan;
    @Column(name = "soDienThoai")
    private String soDienThoai;
    @Column(name = "gioiTinh")
    private String gioiTinh;

    @ManyToOne
    @JoinColumn(name = "maLoaiSV")
    private LoaiSinhVien loaiSinhVien;
    @ManyToOne
    @JoinColumn(name = "maLopHocDanhNghia")
    private LopHocDanhNghia lopHocDanhNghia;
    @OneToMany(mappedBy = "sinhVien")
    private List<SinhVienLopHP> sinhVienLopHPS = new ArrayList<>();
    @OneToMany(mappedBy = "sinhVien")
    private List<BangDiem> bangDiems = new ArrayList<>();

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv=" + mssv +
                ", matKhau='" + matKhau + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", loaiSinhVien=" + loaiSinhVien +
                ", lopHocDanhNghia=" + lopHocDanhNghia +
                '}';
    }
}
