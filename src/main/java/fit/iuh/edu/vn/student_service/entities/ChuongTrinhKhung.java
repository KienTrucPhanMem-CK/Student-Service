package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ChuongTrinhKhung")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChuongTrinhKhung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChuongTrinhKhung")
    private long maChuongTrinhKhung;
    @ManyToOne
    @JoinColumn(name = "maNganhHoc")
    private NganhHoc nganhHoc;
    @OneToMany(mappedBy = "chuongTrinhKhung")
    private List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungs = new ArrayList<>();

    @Override
    public String toString() {
        return "ChuongTrinhKhung{" +
                "maChuongTrinhKhung=" + maChuongTrinhKhung +
                ", nganhHoc=" + nganhHoc +
                '}';
    }
}
