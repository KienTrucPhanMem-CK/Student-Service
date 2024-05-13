package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.pks.SinhVienLopHPPKs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SinhVienLopHP")
@IdClass(SinhVienLopHPPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SinhVienLopHP {
    private int hocKy;
    private int namHoc;
    private String trangThaiMonHoc;
    private String trangThaiDangKy;

    @Id
    @ManyToOne
    @JoinColumn(name = "mssv")
    private SinhVien sinhVien;
    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
}
