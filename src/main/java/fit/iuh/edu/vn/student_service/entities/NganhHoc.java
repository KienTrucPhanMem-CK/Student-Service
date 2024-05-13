package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NganhHoc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NganhHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNganhHoc")
    private long maNganhHoc;
    private String tenNganhHoc;
    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;
}
