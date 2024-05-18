package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.LoaiLichHoc;
import fit.iuh.edu.vn.student_service.pks.GiangVienLopHocPhanPKs;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GiangVienLopHocPhan")
@IdClass(GiangVienLopHocPhanPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class GiangVienLopHocPhan {
    @Enumerated(EnumType.ORDINAL)
    private LoaiLichHoc loaiLichHoc;
    private String viTri;
    @ElementCollection
    @CollectionTable(name = "lichHocLT", joinColumns = {
            @JoinColumn(name = "maGiangVien", referencedColumnName = "maGiangVien"),
            @JoinColumn(name = "maLopHocPhan", referencedColumnName = "maLopHocPhan")
    })
    @Column(name = "lichHocLT")
    private List<String> lichHocLT;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime thoiGian;
    @Id
    @ManyToOne
    @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;
    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
    @OneToMany(mappedBy = "giangVienLopHocPhan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LichHocTH> lichHocTHList;

}
