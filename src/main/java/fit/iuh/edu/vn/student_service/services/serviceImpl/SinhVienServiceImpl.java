package fit.iuh.edu.vn.student_service.services.serviceImpl;

import fit.iuh.edu.vn.student_service.dtos.SinhVien_DTO;
import fit.iuh.edu.vn.student_service.entities.LopHocDanhNghia;
import fit.iuh.edu.vn.student_service.entities.NganhHoc;
import fit.iuh.edu.vn.student_service.repositories.SinhVienRepository;
import fit.iuh.edu.vn.student_service.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    private final SinhVienRepository sinhVienRepository;

    @Autowired
    public SinhVienServiceImpl(SinhVienRepository sinhVienRepository) {
        this.sinhVienRepository = sinhVienRepository;
    }

    @Override
    public Optional<LopHocDanhNghia> findSinhVienByMssvAndMatkhau(long mssv, String matkhau) {
        return sinhVienRepository.findByMssvAndMatKhau(mssv, matkhau);
    }
}
