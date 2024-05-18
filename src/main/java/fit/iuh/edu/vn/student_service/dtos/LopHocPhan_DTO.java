package fit.iuh.edu.vn.student_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class LopHocPhan_DTO {
    private long maLopHocPhan;
    private String tenLopHocPhan;
    private int soLuongToiDa;
    private String trangThaiLop;
    private String kiHoc;
    private MonHoc_DTO monHoc;
    private double hocPhiTCTH;
    private double hocPhiTCLT;
    private int soTinhChiTH;
    private int soTinhChiLT;
    private int soLuongDaDangKy;
    private LocalDateTime ngayDangKy;

    public LopHocPhan_DTO(long maLopHocPhan, String tenLopHocPhan, int soLuongToiDa, String trangThaiLop, String kiHoc, MonHoc_DTO monHoc, double hocPhiTCTH, double hocPhiTCLT, int soTinhChiTH, int soTinhChiLT, int soLuongDaDangKy) {
        this.maLopHocPhan = maLopHocPhan;
        this.tenLopHocPhan = tenLopHocPhan;
        this.soLuongToiDa = soLuongToiDa;
        this.trangThaiLop = trangThaiLop;
        this.kiHoc = kiHoc;
        this.monHoc = monHoc;
        this.hocPhiTCTH = hocPhiTCTH;
        this.hocPhiTCLT = hocPhiTCLT;
        this.soTinhChiTH = soTinhChiTH;
        this.soTinhChiLT = soTinhChiLT;
        this.soLuongDaDangKy = soLuongDaDangKy;
    }

    public LopHocPhan_DTO(long maLopHocPhan, String tenLopHocPhan, int soLuongToiDa, String trangThaiLop, String kiHoc, MonHoc_DTO monHoc, double hocPhiTCTH, double hocPhiTCLT, int soTinhChiTH, int soTinhChiLT, int soLuongDaDangKy, LocalDateTime ngayDangKy) {
        this.maLopHocPhan = maLopHocPhan;
        this.tenLopHocPhan = tenLopHocPhan;
        this.soLuongToiDa = soLuongToiDa;
        this.trangThaiLop = trangThaiLop;
        this.kiHoc = kiHoc;
        this.monHoc = monHoc;
        this.hocPhiTCTH = hocPhiTCTH;
        this.hocPhiTCLT = hocPhiTCLT;
        this.soTinhChiTH = soTinhChiTH;
        this.soTinhChiLT = soTinhChiLT;
        this.soLuongDaDangKy = soLuongDaDangKy;
        this.ngayDangKy = ngayDangKy;
    }
}
