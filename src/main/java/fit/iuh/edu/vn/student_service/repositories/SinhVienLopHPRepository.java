package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.SinhVienLopHP;
import fit.iuh.edu.vn.student_service.pks.SinhVienLopHPPKs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinhVienLopHPRepository extends JpaRepository<SinhVienLopHP, SinhVienLopHPPKs> {
}