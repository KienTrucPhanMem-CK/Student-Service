package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.TrangThai;
import fit.iuh.edu.vn.student_service.pks.BangDiemPKs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BangDiem")
@IdClass(BangDiemPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BangDiem {
    private double diemGK;
    private double diemTK;
    private double diemCK;
    private double diemChuyenCan;
    private double diemTH;
    private double diemTongKet;
    private double diemThang4;
    private String xepLoai;
    private String ghiChu;
    @Enumerated(EnumType.ORDINAL)
    private TrangThai trangThai;
    @Id
    @ManyToOne
    @JoinColumn(name = "mssv")
    private SinhVien sinhVien;

    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
}
