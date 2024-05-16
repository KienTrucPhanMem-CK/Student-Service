package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.dtos.*;
import fit.iuh.edu.vn.student_service.entities.MonHocChuongTrinhKhung;
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
        Optional<SinhVien> optionalSinhVien = sinhVienService.findSinhVienByMssvAndMatkhau(mssv, matKhau);
        if (optionalSinhVien.isPresent()) {
            SinhVien sinhVien = optionalSinhVien.get();
            SinhVien_DTO sinhVienDto = new SinhVien_DTO(sinhVien.getMssv(),
                    sinhVien.getMatKhau(),
                    sinhVien.getHoTen(),
                    sinhVien.getNgaySinh(),
                    sinhVien.getDiaChi(),
                    sinhVien.getQueQuan(),
                    sinhVien.getSoDienThoai(),
                    sinhVien.getGioiTinh(),
                    sinhVien.getAnhDaiDien(),
                    sinhVien.getEmail(),
                    sinhVien.getLopHocDanhNghia().getMaLopHocDanhNghia(),
                    sinhVien.getLoaiSinhVien().getMaLoaiSV()
            );
            return ResponseEntity.ok(sinhVienDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getMonHocCTK")
    private ResponseEntity<List<MonHocCTK_DTO>> getMonHocCTK(@RequestParam long mssv) {
        List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungList = monHocCTKService.getMonHocCTKByMssv(mssv);
        if (!monHocChuongTrinhKhungList.isEmpty()) {
            List<MonHoc_DTO> monHocDtos = new ArrayList<>();
            List<ChuongTrinhKhung_DTO> chuongTrinhKhungDtos = new ArrayList<>();
            List<KhoaHoc_DTO> khoaHocDtos = new ArrayList<>();
            List<NganhHoc_DTO> nganhHocDtos = new ArrayList<>();
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
//                System.out.println("Môn học chương trình khung: "+ monHocChuongTrinhKhung);
//                MonHoc_DTO monHocDto = new MonHoc_DTO();
//                if (monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().size() > 0)
//                    monHocDto = new MonHoc_DTO(
//                            monHocChuongTrinhKhung.getMonHoc().getMaMonHoc(),
//                            monHocChuongTrinhKhung.getMonHoc().getTenMonHoc(),
//                            monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc(),
//                            monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().get(0).getMaMonHocTienQuyet().getMaMonHoc()
//                    );
//                else
//                    monHocDto = new MonHoc_DTO(
//                            monHocChuongTrinhKhung.getMonHoc().getMaMonHoc(),
//                            monHocChuongTrinhKhung.getMonHoc().getTenMonHoc(),
//                            monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc()
//                    );
//                System.out.println("==============================");
//                System.out.println(monHocDto);
//                KhoaHoc_DTO khoaHocDto = new KhoaHoc_DTO(
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc(),
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getTenKhoaHoc(),
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getNamBatDauHoc()
//                );
//                NganhHoc_DTO nganhHocDto = new NganhHoc_DTO(
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getNganhHoc().getMaNganhHoc(),
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getNganhHoc().getTenNganhHoc(),
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc()
//                );
//                ChuongTrinhKhung_DTO chuongTrinhKhungDto = new ChuongTrinhKhung_DTO(
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getMaChuongTrinhKhung(),
//                        nganhHocDto,
//                        khoaHocDto,
//                        monHocChuongTrinhKhung.getChuongTrinhKhung().getThoiGianHoc()
//                );
//                monHocDtos.add(monHocDto);
//                chuongTrinhKhungDtos.add(chuongTrinhKhungDto);
//                khoaHocDtos.add(khoaHocDto);
//                nganhHocDtos.add(nganhHocDto);
//                System.out.println("==============================");
//                if (monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().size() > 0) {
//                    System.out.println("Ma mon tien quyet: " + monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().get(0).getMaMonHocTienQuyet().getMaMonHoc());
//                    System.out.println("Ma mon hoc: " + monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().get(0).getMonHoc().getMaMonHoc());
//                }

            }

            String loaiMonHoc = "";
            switch (monHocChuongTrinhKhungList.get(0).getLoaiMonHoc().getValue()) {
                case 0:
                    loaiMonHoc += "Bắt buộc";
                    break;
                case 1:
                    loaiMonHoc += "Tùy chọn";
                    break;

            }
//            MonHocCTK_DTO monHocCTKDto = new MonHocCTK_DTO(
//                    monHocDtos,
//                    chuongTrinhKhungDtos,
//                    monHocChuongTrinhKhungList.get(0).getHocKy(),
//                    loaiMonHoc,
//                    monHocChuongTrinhKhungList.get(0).getSoTinChiLyThuyet(),
//                    monHocChuongTrinhKhungList.get(0).getSoTinChiThucHanh()
//            );
            return ResponseEntity.ok(monHocCTK_dtos);
        }
        return ResponseEntity.notFound().build();
    }
}
