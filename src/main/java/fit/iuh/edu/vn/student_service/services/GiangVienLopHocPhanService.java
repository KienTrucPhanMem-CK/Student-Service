package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.entities.GiangVienLopHocPhan;
import fit.iuh.edu.vn.student_service.entities.LichHocTH;

import java.util.List;
import java.util.Optional;

public interface GiangVienLopHocPhanService {
    List<LichHocTH> findGiangVienLopHocPhanByMaLopHP(long maLopHocPhan);
}
