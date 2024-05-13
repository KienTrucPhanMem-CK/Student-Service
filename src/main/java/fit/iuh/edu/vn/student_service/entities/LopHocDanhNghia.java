package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.BacDaoTao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "LopHocDanhNghia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LopHocDanhNghia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLopHocDanhNghia")
    private long maLopHocDanhNghia;
    private String tenLop;
    private BacDaoTao bacDaoTao;
    private String loaiHinhDaoTao;

    @ManyToOne
    @JoinColumn(name = "maGV")
    private GiangVien giangVien;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private NganhHoc nganhHoc;
    @ManyToOne
    @JoinColumn(name = "maKhoaHoc")
    private KhoaHoc khoaHoc;
}
