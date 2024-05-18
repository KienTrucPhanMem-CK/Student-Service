package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.LoaiMonHoc;
import fit.iuh.edu.vn.student_service.pks.MonHocChuongTrinhKhungPKs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MonHocChuongTrinhKhung")
@IdClass(MonHocChuongTrinhKhungPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonHocChuongTrinhKhung {
    private int hocKy;
    @Enumerated(EnumType.ORDINAL)
    private LoaiMonHoc loaiMonHoc;
    @Column(name = "soTinChiThucHanh")
    private int soTinChiThucHanh;
    @Column(name = "SoTinChiLyThuyet")
    private int SoTinChiLyThuyet;
    @Id
    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;
    @Id
    @ManyToOne
    @JoinColumn(name = "maChuongTrinhKhung")
    private ChuongTrinhKhung chuongTrinhKhung;

}
