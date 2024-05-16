package fit.iuh.edu.vn.student_service.services.serviceImpl;

import fit.iuh.edu.vn.student_service.entities.GiangVienLopHocPhan;
import fit.iuh.edu.vn.student_service.repositories.GiangVienLopHocPhanRepository;
import fit.iuh.edu.vn.student_service.services.GiangVienLopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiangVienLopHocPhanServiceImpl implements GiangVienLopHocPhanService {
    private final GiangVienLopHocPhanRepository giangVienLopHocPhanRepository;

    @Autowired
    public GiangVienLopHocPhanServiceImpl(GiangVienLopHocPhanRepository giangVienLopHocPhanRepository) {
        this.giangVienLopHocPhanRepository = giangVienLopHocPhanRepository;
    }

    @Override
    public Optional<GiangVienLopHocPhan> findGiangVienLopHocPhanByMaLopHP(long maLopHocPhan) {
        return giangVienLopHocPhanRepository.findByLopHocPhan_MaLopHocPhan(maLopHocPhan);
    }
}
