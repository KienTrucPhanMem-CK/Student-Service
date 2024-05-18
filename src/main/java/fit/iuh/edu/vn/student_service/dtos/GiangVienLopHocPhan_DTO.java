package fit.iuh.edu.vn.student_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GiangVienLopHocPhan_DTO {
    private GiangVien_DTO giangVien;
    private long maLopHocPhan;
    private String loaiLichHoc;
    private String viTri;
    private List<String> lichHocLT;
    private List<LichHocTH_DTO> lichHocTHList;
    private LocalDateTime thoiGian;
}
