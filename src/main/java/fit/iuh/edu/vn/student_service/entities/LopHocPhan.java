package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.TrangThaiHoc;
import fit.iuh.edu.vn.student_service.enums.TrangThaiLop;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LopHocPhan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LopHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLopHocPhan")
    private long maLopHocPhan;
    private String tenLopHocPhan;
    private int hocKy;
    private int namHoc;
    @Enumerated(EnumType.ORDINAL)
    private TrangThaiHoc trangThaiHoc;
    @Enumerated(EnumType.ORDINAL)
    private TrangThaiLop trangThaiLop;
    private int soLuongToiDa;
    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;
    @OneToMany(mappedBy = "lopHocPhan")
    private List<SinhVienLopHP> sinhVienLopHPS = new ArrayList<>();
    @OneToMany(mappedBy = "lopHocPhan")
    private List<GiangVienLopHocPhan> giangVienLopHocPhans = new ArrayList<>();
    @OneToMany(mappedBy = "lopHocPhan")
    private List<BangDiem> bangDiems = new ArrayList<>();
}
