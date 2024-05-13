package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "KhoaHoc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKhoaHoc")
    private long maKhoaHoc;
    private String tenKhoaHoc;
    private int namHoc;
    @ManyToOne
    @JoinColumn(name = "maChuongTrinhKhung")
    private ChuongTrinhKhung chuongTrinhKhung;
}
