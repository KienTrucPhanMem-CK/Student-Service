package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.TrangThai;
import fit.iuh.edu.vn.student_service.enums.TrangThaiHocPhi;
import fit.iuh.edu.vn.student_service.pks.BangDiemPKs;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BangDiem")
@IdClass(BangDiemPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BangDiem {
    @Column(name = "diemGK")
    private double diemGK;
    @Column(name = "diemChuyenCan")
    private double diemChuyenCan;
    @Column(name = "diemTK")
    private double diemTK;
    @Column(name = "diemTH")
    private double diemTH;
    @Column(name = "diemCK")
    private double diemCK;
    @Column(name = "diemTongKet")
    private double diemTongKet;
    @Column(name = "diemThang4")
    private double diemThang4;
    @Column(name = "diemChu")
    private String diemChu;
    @Column(name = "xepLoai")
    private String xepLoai;
    @Column(name = "ghiChu")
    private String ghiChu;
    @Enumerated(EnumType.ORDINAL)
    private TrangThai trangThai;
    private LocalDateTime ngayDangKy;
    @Enumerated(EnumType.ORDINAL)
    private TrangThaiHocPhi trangThaiHocPhi;
    private String nhomTH;
    @Id
    @ManyToOne
    @JoinColumn(name = "mssv")
    private SinhVien sinhVien;

    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;

    public BangDiem(double diemGK, double diemChuyenCan, double diemTK, double diemTH, double diemCK, TrangThai trangThai, LocalDateTime ngayDangKy, TrangThaiHocPhi trangThaiHocPhi, SinhVien sinhVien, LopHocPhan lopHocPhan, String nhomTH) {
        this.diemGK = diemGK;
        this.diemChuyenCan = diemChuyenCan;
        this.diemTK = diemTK;
        this.diemTH = diemTH;
        this.diemCK = diemCK;
        this.trangThai = trangThai;
        this.ngayDangKy = ngayDangKy;
        this.trangThaiHocPhi = trangThaiHocPhi;
        this.sinhVien = sinhVien;
        this.lopHocPhan = lopHocPhan;
        this.nhomTH = nhomTH;
    }
}
