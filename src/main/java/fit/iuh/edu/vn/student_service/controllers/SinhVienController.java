package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.dtos.*;
import fit.iuh.edu.vn.student_service.entities.LopHocDanhNghia;
import fit.iuh.edu.vn.student_service.entities.MonHocChuongTrinhKhung;
import fit.iuh.edu.vn.student_service.entities.NganhHoc;
import fit.iuh.edu.vn.student_service.entities.SinhVien;
import fit.iuh.edu.vn.student_service.services.MonHocCTKService;
import fit.iuh.edu.vn.student_service.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class SinhVienController {

    private final SinhVienService sinhVienService;
    private final MonHocCTKService monHocCTKService;

    @Autowired
    public SinhVienController(SinhVienService sinhVienService, MonHocCTKService monHocCTKService) {
        this.sinhVienService = sinhVienService;
        this.monHocCTKService = monHocCTKService;
    }

    @GetMapping("/getStudent")
    private ResponseEntity<SinhVien_DTO> getStudentById(@RequestParam Long mssv, @RequestParam String matKhau) {
        Optional<LopHocDanhNghia> lopHocDanhNghiaOptional = sinhVienService.findSinhVienByMssvAndMatkhau(mssv, matKhau);
        if (lopHocDanhNghiaOptional.isPresent()) {
            LopHocDanhNghia lopHocDanhNghia = lopHocDanhNghiaOptional.get();
            SinhVien_DTO sinhVien_dto = new SinhVien_DTO();
            int thuTuSinhVien = 0;
            if (lopHocDanhNghia.getSinhViens().size() > 0) {
                for (int i = 0; i < lopHocDanhNghia.getSinhViens().size(); i++) {
                    if (lopHocDanhNghia.getSinhViens().get(i).getMssv() == mssv) {
                        thuTuSinhVien = i;
                    }
                }
                String bacDaoTao = "";
                switch (lopHocDanhNghia.getBacDaoTao().getValue()) {
                    case 0:
                        bacDaoTao += "Cao Đẳng";
                        break;
                    case 1:
                        bacDaoTao += "Đại Học";
                        break;
                    case 2:
                        bacDaoTao += "Thạc Sỹ";
                        break;
                    case 3:
                        bacDaoTao += "Liên Thông";
                        break;
                }
                sinhVien_dto = new SinhVien_DTO(
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getMssv(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getMatKhau(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getHoTen(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getNgaySinh(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getDiaChi(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getQueQuan(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getSoDienThoai(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getGioiTinh(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getAnhDaiDien(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getEmail(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getLoaiSinhVien().getMaLoaiSV(),
                        lopHocDanhNghia.getMaLopHocDanhNghia(),
                        lopHocDanhNghia.getTenLopHocDanhNghia(),
                        bacDaoTao,
                        lopHocDanhNghia.getLoaiHinhDaoTao(),
                        lopHocDanhNghia.getKhoaHoc().getMaKhoaHoc(),
                        lopHocDanhNghia.getKhoaHoc().getTenKhoaHoc(),
                        lopHocDanhNghia.getKhoaHoc().getNamBatDauHoc(),
                        lopHocDanhNghia.getNganhHoc().getMaNganhHoc(),
                        lopHocDanhNghia.getNganhHoc().getTenNganhHoc(),
                        lopHocDanhNghia.getNganhHoc().getKhoa().getMaKhoa(),
                        lopHocDanhNghia.getNganhHoc().getKhoa().getTenKhoa()
                );
            }
            return ResponseEntity.ok(sinhVien_dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getMonHocCTK")
    private ResponseEntity<List<MonHocCTK_DTO>> getMonHocCTK(@RequestParam long mssv) {
        List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungList = monHocCTKService.getMonHocCTKByMssv(mssv);
        if (!monHocChuongTrinhKhungList.isEmpty()) {
            List<MonHocCTK_DTO> monHocCTK_dtos = new ArrayList<>();
            for (MonHocChuongTrinhKhung monHocChuongTrinhKhung : monHocChuongTrinhKhungList) {
                String loaiMonHoc = "";
                switch (monHocChuongTrinhKhung.getLoaiMonHoc().getValue()) {
                    case 0:
                        loaiMonHoc += "Bắt buộc";
                        break;
                    case 1:
                        loaiMonHoc += "Tùy chọn";
                        break;

                }
                MonHoc_DTO monHocDto = new MonHoc_DTO();
                if (monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().size() > 0) {
//                    for (int i=0; i<monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().size();i++){
//                        System.out.println("Mon hoc tien quyet " + i + " " + monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().get(0).getMaMonHocTienQuyet());
//                    }
                    monHocDto = new MonHoc_DTO(monHocChuongTrinhKhung.getMonHoc().getMaMonHoc(),
                            monHocChuongTrinhKhung.getMonHoc().getTenMonHoc(),
                            monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc(),
                            monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().get(0).getMaMonHocTienQuyet().getMaMonHoc()
                    );
                } else {
                    monHocDto = new MonHoc_DTO(monHocChuongTrinhKhung.getMonHoc().getMaMonHoc(),
                            monHocChuongTrinhKhung.getMonHoc().getTenMonHoc(),
                            monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc());
                }

                MonHocCTK_DTO monHocCTK_dto = new MonHocCTK_DTO(monHocDto,
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getMaChuongTrinhKhung(),
                        monHocChuongTrinhKhung.getHocKy(),
                        loaiMonHoc,
                        monHocChuongTrinhKhung.getSoTinChiLyThuyet(),
                        monHocChuongTrinhKhung.getSoTinChiThucHanh()
                );
                monHocCTK_dtos.add(monHocCTK_dto);
            }
            return ResponseEntity.ok(monHocCTK_dtos);
        }
        return ResponseEntity.notFound().build();
    }
}
