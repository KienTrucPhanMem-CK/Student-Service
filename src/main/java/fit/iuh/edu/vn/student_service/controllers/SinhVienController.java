package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.dtos.*;
import fit.iuh.edu.vn.student_service.entities.*;
import fit.iuh.edu.vn.student_service.repositories.BangDiemRepository;
import fit.iuh.edu.vn.student_service.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
@RequiredArgsConstructor
public class SinhVienController {

    private final SinhVienService sinhVienService;
    private final MonHocCTKService monHocCTKService;
    private final LopHocPhanService lopHocPhanService;
    private final GiangVienLopHocPhanService giangVienLopHocPhanService;
    private final BangDiemService bangDiemService;
    private final BangDiemRepository bangDiemRepository;

    @GetMapping("/getStudent")
    private ResponseEntity<SinhVien_DTO> getStudentById(@RequestParam Long mssv, @RequestParam String matKhau) {
        Optional<LopHocDanhNghia> lopHocDanhNghiaOptional = sinhVienService.findSinhVienByMssvAndMatkhau(mssv, matKhau);
        if (lopHocDanhNghiaOptional.isPresent()) {
            LopHocDanhNghia lopHocDanhNghia = lopHocDanhNghiaOptional.get();
            SinhVien_DTO sinhVien_dto = new SinhVien_DTO();
            int thuTuSinhVien = 0;
            if (!lopHocDanhNghia.getSinhViens().isEmpty()) {
                for (int i = 0; i < lopHocDanhNghia.getSinhViens().size(); i++) {
                    if (lopHocDanhNghia.getSinhViens().get(i).getMssv() == mssv) {
                        thuTuSinhVien = i;
                    }
                }
                String bacDaoTao = "";
                switch (lopHocDanhNghia.getBacDaoTao().getValue()) {
                    case 0 -> bacDaoTao += "Cao Đẳng";
                    case 1 -> bacDaoTao += "Đại Học";
                    case 2 -> bacDaoTao += "Thạc Sỹ";
                    case 3 -> bacDaoTao += "Liên Thông";
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
                    case 0 -> loaiMonHoc += "Bắt buộc";
                    case 1 -> loaiMonHoc += "Tùy chọn";
                }
                MonHoc_DTO monHocDto;
                if (!monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().isEmpty()) {
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
                NganhHoc_DTO nganhHoc_dto = new NganhHoc_DTO(
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getNganhHoc().getMaNganhHoc(),
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getNganhHoc().getTenNganhHoc()
                );
                KhoaHoc_DTO khoaHoc_dto = new KhoaHoc_DTO(monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc(),
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getTenKhoaHoc(),
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getNamBatDauHoc()
                );
                ChuongTrinhKhung_DTO chuongTrinhKhung_dto = new ChuongTrinhKhung_DTO(monHocChuongTrinhKhung.getChuongTrinhKhung().getMaChuongTrinhKhung(),
                        nganhHoc_dto,
                        khoaHoc_dto,
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getThoiGianHoc()
                );
                MonHocCTK_DTO monHocCTK_dto = new MonHocCTK_DTO(monHocDto,
                        chuongTrinhKhung_dto,
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

    @GetMapping("/getLopHocPhan")
    private ResponseEntity<List<LopHocPhan_DTO>> getLopHocPhan(@RequestParam long maMonHoc, @RequestParam String kiHoc) {
        List<LopHocPhan> lopHocPhans = lopHocPhanService.findLopHocPhanByMaMHAndKiHoc(maMonHoc, kiHoc);
        if (lopHocPhans != null) {
            List<LopHocPhan_DTO> lopHocPhan_dtos = new ArrayList<>();
            for (LopHocPhan lopHocPhan : lopHocPhans) {
                String trangThaiLop = "";
                switch (lopHocPhan.getTrangThaiLop().getValue()) {
                    case 0 -> trangThaiLop += "Đã khóa";
                    case 1 -> trangThaiLop += "Chờ sinh viên đăng ký";
                }
                MonHoc_DTO monHoc_dto = new MonHoc_DTO(lopHocPhan.getMonHoc().getMaMonHoc(),
                        lopHocPhan.getMonHoc().getTenMonHoc(),
                        lopHocPhan.getMonHoc().getKhoa().getMaKhoa()
                );
                LopHocPhan_DTO lopHocPhan_dto = new LopHocPhan_DTO(
                        lopHocPhan.getMaLopHocPhan(),
                        lopHocPhan.getTenLopHocPhan(),
                        lopHocPhan.getSoLuongToiDa(),
                        trangThaiLop,
                        lopHocPhan.getKiHoc(),
                        monHoc_dto,
                        lopHocPhan.getHocPhiTCTH(),
                        lopHocPhan.getHocPhiTCLT(),
                        lopHocPhan.getSoTinChiTH(),
                        lopHocPhan.getSoTinChiLT(),
                        lopHocPhan.getSoLuongDaDangKy()
                );
                lopHocPhan_dtos.add(lopHocPhan_dto);
            }

            return ResponseEntity.ok(lopHocPhan_dtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getGiangVienLopHP")
    private ResponseEntity<GiangVienLopHocPhan_DTO> getGiangVienLopHocPhan(@RequestParam long maLopHocPhan) {
        Optional<GiangVienLopHocPhan> optionalGiangVienLopHocPhan = giangVienLopHocPhanService.findGiangVienLopHocPhanByMaLopHP(maLopHocPhan);
        if (optionalGiangVienLopHocPhan.isPresent()) {
            GiangVienLopHocPhan giangVienLopHocPhan = optionalGiangVienLopHocPhan.get();
            GiangVien_DTO giangVien_dto = new GiangVien_DTO(giangVienLopHocPhan.getGiangVien().getMaGiangVien(),
                    giangVienLopHocPhan.getGiangVien().getTenGiangVien(),
                    giangVienLopHocPhan.getGiangVien().getChucVu(),
                    giangVienLopHocPhan.getGiangVien().getSoDienThoai(),
                    giangVienLopHocPhan.getGiangVien().getDiaChi(),
                    giangVienLopHocPhan.getGiangVien().getGioiTinh(),
                    giangVienLopHocPhan.getGiangVien().getNgaySinh()
            );
            String loaiLichHoc = "";
            switch (giangVienLopHocPhan.getLoaiLichHoc().getValue()) {
                case 0 -> loaiLichHoc += "LT";
                case 1 -> loaiLichHoc += "TH";
            }
            List<String> lichHocLT = new ArrayList<>();
            for (int i = 0; i < giangVienLopHocPhan.getLichHocLT().size(); i++) {
                lichHocLT.add(giangVienLopHocPhan.getLichHocLT().get(i));
            }
            List<String> lichHocs = new ArrayList<>();
            for (int i = 0; i < giangVienLopHocPhan.getLichHocTH().getLichHoc().size(); i++) {
                lichHocs.add(giangVienLopHocPhan.getLichHocTH().getLichHoc().get(i));
            }
            LichHocTH_DTO lichHocTH_dto = new LichHocTH_DTO(
                    giangVienLopHocPhan.getLichHocTH().getMaLichHocTH(),
                    giangVienLopHocPhan.getLichHocTH().getTenNhomLichHocTH(),
                    giangVienLopHocPhan.getLichHocTH().getViTri(),
                    lichHocs
            );

            GiangVienLopHocPhan_DTO giangVienLopHocPhan_dto = new GiangVienLopHocPhan_DTO(
                    giangVien_dto,
                    giangVienLopHocPhan.getLopHocPhan().getMaLopHocPhan(),
                    loaiLichHoc,
                    giangVienLopHocPhan.getViTri(),
                    lichHocLT,
                    lichHocTH_dto,
                    giangVienLopHocPhan.getThoiGian()
            );
            return ResponseEntity.ok(giangVienLopHocPhan_dto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getLopHocPhanByMssvAndKihoc")
    private ResponseEntity<LopHocPhan_DTO> getLopHocPhanByMssvAndKihoc(@RequestParam long mssv, @RequestParam String kiHoc) {
        if (lopHocPhanService.findLopHocPhanByMsssAndKihoc(mssv, kiHoc).isPresent()) {
            LopHocPhan lopHocPhan = lopHocPhanService.findLopHocPhanByMsssAndKihoc(mssv, kiHoc).get();
            String trangThaiLop = "";
            switch (lopHocPhan.getTrangThaiLop().getValue()) {
                case 0 -> trangThaiLop += "Đã khóa";
                case 1 -> trangThaiLop += "Chờ sinh viên đăng ký";
            }
            MonHoc_DTO monHoc_dto = new MonHoc_DTO(
                    lopHocPhan.getMonHoc().getMaMonHoc(),
                    lopHocPhan.getMonHoc().getTenMonHoc(),
                    lopHocPhan.getMonHoc().getKhoa().getMaKhoa()
            );
            LocalDateTime ngayDangKy = null;
            for (int i = 0; i < lopHocPhan.getBangDiems().size(); i++) {
                if (lopHocPhan.getBangDiems().get(i).getSinhVien().getMssv() == mssv) {
                    ngayDangKy = lopHocPhan.getBangDiems().get(i).getNgayDangKy();
                }
            }
            LopHocPhan_DTO lopHocPhan_dto = new LopHocPhan_DTO(
                    lopHocPhan.getMaLopHocPhan(),
                    lopHocPhan.getTenLopHocPhan(),
                    lopHocPhan.getSoLuongToiDa(),
                    trangThaiLop,
                    lopHocPhan.getKiHoc(),
                    monHoc_dto,
                    lopHocPhan.getHocPhiTCTH(),
                    lopHocPhan.getHocPhiTCLT(),
                    lopHocPhan.getSoTinChiTH(),
                    lopHocPhan.getSoTinChiLT(),
                    lopHocPhan.getSoLuongDaDangKy(),
                    ngayDangKy
            );
            return ResponseEntity.ok(lopHocPhan_dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addBangDiem")
    private ResponseEntity<?> taoBangDiem(@RequestBody BangDiem bangDiem) {
        try {
            BangDiem bangDiemAddToDB = bangDiemService.taoBangDiem(bangDiem);
            BangDiem_DTO bangDiem_dto = new BangDiem_DTO(
                    bangDiemAddToDB.getDiemGK(),
                    bangDiemAddToDB.getDiemChuyenCan(),
                    bangDiemAddToDB.getDiemTK(),
                    bangDiemAddToDB.getDiemTH(),
                    bangDiemAddToDB.getDiemCK(),
                    bangDiemAddToDB.getDiemTongKet(),
                    bangDiemAddToDB.getDiemThang4(),
                    bangDiemAddToDB.getDiemChu(),
                    bangDiemAddToDB.getXepLoai(),
                    bangDiemAddToDB.getGhiChu(),
                    bangDiemAddToDB.getTrangThai(),
                    bangDiemAddToDB.getNgayDangKy(),
                    bangDiemAddToDB.getTrangThaiHocPhi(),
                    bangDiemAddToDB.getNhomTH(),
                    bangDiemAddToDB.getSinhVien().getMssv(),
                    bangDiemAddToDB.getLopHocPhan().getMaLopHocPhan()
            );
            return ResponseEntity.ok(bangDiem_dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khi tạo bảng điểm!");
        }
    }
}
