package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GiangVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maGiangVien")
    private long maGiangVien;
    private String tenGiangVien;
    private String chucVu;
    private String soDienThoai;
    private String diaChi;
    private String gioiTinh;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime ngaySinh;
    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;
    @OneToMany(mappedBy = "giangVien")
    private List<GiangVienLopHocPhan> giangVienLopHocPhans = new ArrayList<>();

    @Override
    public String toString() {
        return "GiangVien{" +
                "maGiangVien=" + maGiangVien +
                ", tenGiangVien='" + tenGiangVien + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", khoa=" + khoa +
                '}';
    }
}
