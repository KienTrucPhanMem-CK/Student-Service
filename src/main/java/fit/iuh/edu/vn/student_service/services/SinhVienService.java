package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.entities.SinhVien;
import fit.iuh.edu.vn.student_service.repositories.SinhVienRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface SinhVienService {
    Optional<SinhVien> findSinhVienByMssvAndMatkhau(long mssv, String matkhau);
}
