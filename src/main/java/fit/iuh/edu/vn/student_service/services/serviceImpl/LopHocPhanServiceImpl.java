package fit.iuh.edu.vn.student_service.services.serviceImpl;

import fit.iuh.edu.vn.student_service.entities.LopHocPhan;
import fit.iuh.edu.vn.student_service.repositories.LopHocPhanRepository;
import fit.iuh.edu.vn.student_service.services.LopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LopHocPhanServiceImpl implements LopHocPhanService {
    private final LopHocPhanRepository lopHocPhanRepository;

    @Autowired
    public LopHocPhanServiceImpl(LopHocPhanRepository lopHocPhanRepository) {
        this.lopHocPhanRepository = lopHocPhanRepository;
    }

    @Override
    public Optional<LopHocPhan> findLopHocPhanByMaMHAndKiHoc(long maMonHoc, String kiHoc) {
        return lopHocPhanRepository.findByMonHoc_MaMonHocAndKiHoc(maMonHoc, kiHoc);
    }
}
