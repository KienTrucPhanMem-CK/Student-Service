package fit.iuh.edu.vn.student_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LichHocTH_DTO {
    private long maLichHocTH;
    private String tenNhomLichHocTH;
    private String viTri;
    private List<String> lichHoc;
    private long maGiangVienLopHocPhan;
}
