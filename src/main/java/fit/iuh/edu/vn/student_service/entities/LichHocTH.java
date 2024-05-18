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
    @CollectionTable(name = "lichHoc", joinColumns = @JoinColumn(name = "maLichHocTH"))
    @Column(name = "lichHoc")
    private List<String> lichHoc;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "maGiangVien", referencedColumnName = "maGiangVien"),
            @JoinColumn(name = "maLopHocPhan", referencedColumnName = "maLopHocPhan")
    })
    private GiangVienLopHocPhan giangVienLopHocPhan;

    public LichHocTH(String tenNhomLichHocTH, String viTri, List<String> lichHoc) {
        this.tenNhomLichHocTH = tenNhomLichHocTH;
        this.viTri = viTri;
        this.lichHoc = lichHoc;
    }
}
