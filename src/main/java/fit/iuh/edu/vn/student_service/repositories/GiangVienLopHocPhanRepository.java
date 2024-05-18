package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.GiangVienLopHocPhan;
import fit.iuh.edu.vn.student_service.entities.LichHocTH;
import fit.iuh.edu.vn.student_service.pks.GiangVienLopHocPhanPKs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GiangVienLopHocPhanRepository extends JpaRepository<GiangVienLopHocPhan, GiangVienLopHocPhanPKs> {
    @Query("select lhth from GiangVienLopHocPhan  gvlhp \n" +
            " join LichHocTH  lhth on lhth.giangVienLopHocPhan.lopHocPhan.maLopHocPhan = gvlhp.lopHocPhan.maLopHocPhan\n" +
            " where gvlhp.lopHocPhan.maLopHocPhan = ?1")
    List<LichHocTH> findGiangVienLopHocPhanAndLichHocTH(long maLopHocPhan);
}