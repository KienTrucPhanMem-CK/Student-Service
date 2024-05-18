package fit.iuh.edu.vn.student_service.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import fit.iuh.edu.vn.student_service.enums.TrangThai;
import fit.iuh.edu.vn.student_service.enums.TrangThaiHocPhi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BangDiem_DTO {
    private double diemGK;
    private double diemChuyenCan;
    private double diemTK;
    private double diemTH;
    private double diemCK;
    private double diemTongKet;
    private double diemThang4;
    private String diemChu;
    private String xepLoai;
    private String ghiChu;
    private TrangThai trangThai;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private LocalDateTime ngayDangKy;
    private TrangThaiHocPhi trangThaiHocPhi;
    private String nhomTH;
    private long maSinhVien;
    private long maLopHocPhan;
}
