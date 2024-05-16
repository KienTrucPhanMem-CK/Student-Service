package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.entities.GiangVienLopHocPhan;

import java.util.Optional;

public interface GiangVienLopHocPhanService {
    Optional<GiangVienLopHocPhan> findGiangVienLopHocPhanByMaLopHP(long maLopHocPhan);
}
