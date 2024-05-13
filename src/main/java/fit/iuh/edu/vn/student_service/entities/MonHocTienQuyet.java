package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MonHocTienQuyet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonHocTienQuyet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maMonHocTienQuyet")
    private long maMonHocTienQuyet;
    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;
}
