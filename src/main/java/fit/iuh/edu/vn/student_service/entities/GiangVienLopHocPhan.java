package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.pks.GiangVienLopHocPhanPKs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GiangVienLopHocPhan")
@IdClass(GiangVienLopHocPhanPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GiangVienLopHocPhan {
    @Id
    @ManyToOne
    @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;
    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
}
