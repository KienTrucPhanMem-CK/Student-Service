package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.entities.MonHocChuongTrinhKhung;

import java.util.List;

public interface MonHocCTKService {
    List<MonHocChuongTrinhKhung> getMonHocCTKByMssv(long mssv);
}
