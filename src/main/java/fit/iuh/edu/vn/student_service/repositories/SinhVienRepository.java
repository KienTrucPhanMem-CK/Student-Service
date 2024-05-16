package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
    Optional<SinhVien> findByMssvAndMatKhau(long mssv, String matKhau);
}