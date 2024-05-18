package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "LichHocTH")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LichHocTH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLichHocTH")
    private long maLichHocTH;
    private String tenNhomLichHocTH;
    private String viTri;
    @ElementCollection
    private List<String> lichHoc;
    @OneToOne(mappedBy = "lichHocTH")
    private GiangVienLopHocPhan giangVienLopHocPhan;

    public LichHocTH(String tenNhomLichHocTH, String viTri, List<String> lichHoc) {
        this.tenNhomLichHocTH = tenNhomLichHocTH;
        this.viTri = viTri;
        this.lichHoc = lichHoc;
    }
}
