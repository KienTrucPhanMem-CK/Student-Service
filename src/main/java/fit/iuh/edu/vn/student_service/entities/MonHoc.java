package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.LoaiMonHoc;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MonHoc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maMonHoc")
    private long maMonHoc;
    private String tenMonHoc;
    @Enumerated(EnumType.ORDINAL)
    private LoaiMonHoc loaiMonHoc;
    private int soTinChiThucHanh;
    private int soTinChiLyThuyet;
    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;
    @OneToMany(mappedBy = "monHoc")
    private List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungs = new ArrayList<>();

    @Override
    public String toString() {
        return "MonHoc{" +
                "maMonHoc=" + maMonHoc +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                ", loaiMonHoc=" + loaiMonHoc +
                ", soTinChiThucHanh=" + soTinChiThucHanh +
                ", soTinChiLyThuyet=" + soTinChiLyThuyet +
                ", khoa=" + khoa +
                '}';
    }
}
