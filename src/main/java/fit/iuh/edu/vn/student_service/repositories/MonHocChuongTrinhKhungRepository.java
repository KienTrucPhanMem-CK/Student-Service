package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.MonHocChuongTrinhKhung;
import fit.iuh.edu.vn.student_service.pks.MonHocChuongTrinhKhungPKs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonHocChuongTrinhKhungRepository extends JpaRepository<MonHocChuongTrinhKhung, MonHocChuongTrinhKhungPKs> {
}