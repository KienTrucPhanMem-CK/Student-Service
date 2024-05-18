package fit.iuh.edu.vn.student_service.services.serviceImpl;

import fit.iuh.edu.vn.student_service.entities.LopHocPhan;
import fit.iuh.edu.vn.student_service.repositories.LopHocPhanRepository;
import fit.iuh.edu.vn.student_service.services.LopHocPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LopHocPhanServiceImpl implements LopHocPhanService {
    private final LopHocPhanRepository lopHocPhanRepository;

    @Override
    public List<LopHocPhan> findLopHocPhanByMaMHAndKiHoc(long maMonHoc, String kiHoc) {
        return lopHocPhanRepository.findByMonHoc_MaMonHocAndKiHoc(maMonHoc, kiHoc);
    }

    @Override
    public Optional<LopHocPhan> findLopHocPhanByMsssAndKihoc(long mssv, String kihoc) {
        return lopHocPhanRepository.findLopHocPhanByMsssAndKihoc(mssv, kihoc);
    }


}
