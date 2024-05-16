package fit.iuh.edu.vn.student_service.services.serviceImpl;

import fit.iuh.edu.vn.student_service.entities.MonHocChuongTrinhKhung;
import fit.iuh.edu.vn.student_service.repositories.MonHocChuongTrinhKhungRepository;
import fit.iuh.edu.vn.student_service.services.MonHocCTKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocCTKServiceImpl implements MonHocCTKService {
    private final MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository;

    @Autowired
    public MonHocCTKServiceImpl(MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository) {
        this.monHocChuongTrinhKhungRepository = monHocChuongTrinhKhungRepository;
    }

    @Override
    public List<MonHocChuongTrinhKhung> getMonHocCTKByMssv(long mssv) {
        return monHocChuongTrinhKhungRepository.findMonHocChuongTrinhKhungByMssv(mssv);
    }
}
