package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.entities.LopHocPhan;

import java.util.List;
import java.util.Optional;

public interface LopHocPhanService {
    List<LopHocPhan> findLopHocPhanByMaMHAndKiHoc(long maMonHoc, String kiHoc);
    Optional<LopHocPhan> findLopHocPhanByMsssAndKihoc(long mssv, String kihoc);
}
