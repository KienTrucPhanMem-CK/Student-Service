package fit.iuh.edu.vn.student_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SinhVien_DTO {
    private long mssv;
    private String matKhau;
    private String hoTen;
    private LocalDateTime ngaySinh;
    private String diaChi;
    private String queQuan;
    private String soDienThoai;
    private String gioiTinh;
    private String anhDaiDien;
    private String email;
    private long maLopHocDanhNghia;
    private long maLoaiSinhVien;
}
