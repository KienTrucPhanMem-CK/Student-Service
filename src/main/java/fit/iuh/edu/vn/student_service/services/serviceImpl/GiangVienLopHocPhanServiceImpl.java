package fit.iuh.edu.vn.student_service.services.serviceImpl;

import fit.iuh.edu.vn.student_service.entities.GiangVienLopHocPhan;
import fit.iuh.edu.vn.student_service.entities.LichHocTH;
import fit.iuh.edu.vn.student_service.repositories.GiangVienLopHocPhanRepository;
import fit.iuh.edu.vn.student_service.services.GiangVienLopHocPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GiangVienLopHocPhanServiceImpl implements GiangVienLopHocPhanService {
    private final GiangVienLopHocPhanRepository giangVienLopHocPhanRepository;

    @Override
    public List<LichHocTH> findGiangVienLopHocPhanByMaLopHP(long maLopHocPhan) {
        return giangVienLopHocPhanRepository.findGiangVienLopHocPhanAndLichHocTH(maLopHocPhan);
    }
}
