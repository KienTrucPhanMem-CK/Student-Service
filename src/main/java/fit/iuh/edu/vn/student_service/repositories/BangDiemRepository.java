package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.dtos.BangDiem_DTO;
import fit.iuh.edu.vn.student_service.entities.BangDiem;
import fit.iuh.edu.vn.student_service.pks.BangDiemPKs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface BangDiemRepository extends JpaRepository<BangDiem, BangDiemPKs> {
}