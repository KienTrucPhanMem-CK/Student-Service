package fit.iuh.edu.vn.student_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MonHocCTK_DTO {
    private MonHoc_DTO maMonHoc;
    private long maChuongTrinhKhung;
//    private List<MonHoc_DTO> monHocs;
//    private List<ChuongTrinhKhung_DTO> chuongTrinhKhungs;
    private int hocKy;
    private String loaiMonHoc;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;
}
