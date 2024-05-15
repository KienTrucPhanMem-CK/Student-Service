package fit.iuh.edu.vn.student_service.configs;

import fit.iuh.edu.vn.student_service.entities.*;
import fit.iuh.edu.vn.student_service.enums.*;
import fit.iuh.edu.vn.student_service.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataSampleConfig {
    private BangDiemRepository bangDiemRepository;
    private ChuongTrinhKhungRepository chuongTrinhKhungRepository;
    private GiangVienLopHocPhanRepository giangVienLopHocPhanRepository;
    private GiangVienRepository giangVienRepository;
    private KhoaHocRepository khoaHocRepository;
    private KhoaRepository khoaRepository;
    private LoaiSinhVienRepository loaiSinhVienRepository;
    private LopHocDanhNghiaRepository lopHocDanhNghiaRepository;
    private LopHocPhanRepository lopHocPhanRepository;
    private MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository;
    private MonHocRepository monHocRepository;
    private MonHocTienQuyetRepository monHocTienQuyetRepository;
    private NganhHocRepository nganhHocRepository;
    private SinhVienRepository sinhVienRepository;

    @Autowired
    public DataSampleConfig(BangDiemRepository bangDiemRepository,
                            ChuongTrinhKhungRepository chuongTrinhKhungRepository,
                            GiangVienLopHocPhanRepository giangVienLopHocPhanRepository,
                            GiangVienRepository giangVienRepository,
                            KhoaHocRepository khoaHocRepository,
                            KhoaRepository khoaRepository,
                            LoaiSinhVienRepository loaiSinhVienRepository,
                            LopHocDanhNghiaRepository lopHocDanhNghiaRepository,
                            LopHocPhanRepository lopHocPhanRepository,
                            MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository,
                            MonHocRepository monHocRepository,
                            MonHocTienQuyetRepository monHocTienQuyetRepository,
                            NganhHocRepository nganhHocRepository,
                            SinhVienRepository sinhVienRepository) {
        this.bangDiemRepository = bangDiemRepository;
        this.chuongTrinhKhungRepository = chuongTrinhKhungRepository;
        this.giangVienLopHocPhanRepository = giangVienLopHocPhanRepository;
        this.giangVienRepository = giangVienRepository;
        this.khoaHocRepository = khoaHocRepository;
        this.khoaRepository = khoaRepository;
        this.loaiSinhVienRepository = loaiSinhVienRepository;
        this.lopHocDanhNghiaRepository = lopHocDanhNghiaRepository;
        this.lopHocPhanRepository = lopHocPhanRepository;
        this.monHocChuongTrinhKhungRepository = monHocChuongTrinhKhungRepository;
        this.monHocRepository = monHocRepository;
        this.monHocTienQuyetRepository = monHocTienQuyetRepository;
        this.nganhHocRepository = nganhHocRepository;
        this.sinhVienRepository = sinhVienRepository;
    }

//    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // insert Khoa
            Khoa khoaCNTT = new Khoa("Công nghệ thông tin");
            Khoa khoaKT = new Khoa("Tài chính");
            khoaRepository.save(khoaCNTT);
            khoaRepository.save(khoaKT);
            // insert Nganh hoc
            NganhHoc nganhKTPM = new NganhHoc("Kỹ thuật phần mềm", khoaCNTT);
            NganhHoc nganhHocKT = new NganhHoc("Tài chính ngân hàng", khoaKT);
            nganhHocRepository.save(nganhKTPM);
            nganhHocRepository.save(nganhHocKT);
            // insert Giang vien
            GiangVien gv1 = new GiangVien(
                    "Võ Văn Hải",
                    "TS",
                    "0339717894",
                    "666 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1986, 6, 13, 0, 0),
                    khoaCNTT
            );
            GiangVien gv2 = new GiangVien(
                    "Nguyễn Tuấn Hiệp",
                    "Ths",
                    "0339717894",
                    "111 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(2002, 9, 18, 0, 0),
                    khoaKT
            );
            giangVienRepository.save(gv1);
            giangVienRepository.save(gv2);
            // insert Khoa hoc
            KhoaHoc khoa16 = new KhoaHoc("K16", 2020);
            KhoaHoc khoa17 = new KhoaHoc("K17", 2021);
            KhoaHoc khoa18 = new KhoaHoc("K18", 2022);
            khoaHocRepository.save(khoa16);
            khoaHocRepository.save(khoa17);
            khoaHocRepository.save(khoa18);
            // insert Chuong trinh khung
            ChuongTrinhKhung chuongTrinhKhung1 = new ChuongTrinhKhung("9", nganhKTPM, khoa16);
            ChuongTrinhKhung chuongTrinhKhung2 = new ChuongTrinhKhung("9", nganhKTPM, khoa17);
            ChuongTrinhKhung chuongTrinhKhung3 = new ChuongTrinhKhung("9", nganhHocKT, khoa18);
            chuongTrinhKhungRepository.save(chuongTrinhKhung1);
            chuongTrinhKhungRepository.save(chuongTrinhKhung2);
            chuongTrinhKhungRepository.save(chuongTrinhKhung3);
            // insert Loai sinh vien
            LoaiSinhVien loaiSinhVien1 = new LoaiSinhVien(TenLoai.DANG_HOC);
            LoaiSinhVien loaiSinhVien2 = new LoaiSinhVien(TenLoai.THOI_HOC);
            LoaiSinhVien loaiSinhVien3 = new LoaiSinhVien(TenLoai.DA_TOT_NGHIEP);
            loaiSinhVienRepository.save(loaiSinhVien1);
            loaiSinhVienRepository.save(loaiSinhVien2);
            loaiSinhVienRepository.save(loaiSinhVien3);
            // insert Lop hoc danh nghia
            LopHocDanhNghia lopHocDanhNghia1 = new LopHocDanhNghia("DHKTPM16A",
                    BacDaoTao.DAI_HOC,
                    "Chính quy",
                    gv1,
                    nganhKTPM,
                    khoa16
            );
            LopHocDanhNghia lopHocDanhNghia2 = new LopHocDanhNghia("DKKTTC17B",
                    BacDaoTao.THAC_SI,
                    "Chính quy",
                    gv2,
                    nganhHocKT,
                    khoa17
            );
            LopHocDanhNghia lopHocDanhNghia3 = new LopHocDanhNghia("DKTPM17A",
                    BacDaoTao.DAI_HOC,
                    "Chính quy",
                    gv1,
                    nganhKTPM,
                    khoa17
            );
            lopHocDanhNghiaRepository.save(lopHocDanhNghia1);
            lopHocDanhNghiaRepository.save(lopHocDanhNghia2);
            lopHocDanhNghiaRepository.save(lopHocDanhNghia3);
            // insert Mon hoc
            MonHoc monHoc1 = new MonHoc("Lập trình hướng đối tượng", khoaCNTT);
            MonHoc monHoc2 = new MonHoc("Luật kinh tế", khoaKT);
            monHocRepository.save(monHoc1);
            monHocRepository.save(monHoc2);
            // insert Sinh vien
            SinhVien sv1 = new SinhVien(20111311,
                    "123456",
                    "Nguyễn Tuấn Hiệp",
                    LocalDateTime.of(2002, 9, 14, 0, 0),
                    "121 Quang Trung, Gò vấp ",
                    "Hải Phòng",
                    "0339717894",
                    "Nam",
                    "https://th.bing.com/th/id/R.e089a43cd9546701b048d2ab47bd45a9?rik=YUUjgVi2gtRQQw&pid=ImgRaw&r=0",
                    "bohiepdzai@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia1
            );
            SinhVien sv2 = new SinhVien(20111601,
                    "123456",
                    "Phan Nguyễn Hoài Hiệp",
                    LocalDateTime.of(2002, 6, 13, 0, 0),
                    "121 Lê Đức Thọ, Gò Vấp",
                    "Tây Ninh",
                    "0974067552",
                    "Nam",
                    "https://th.bing.com/th/id/OIP.mIf9ZAHku6YCPc4qT14avgHaK0?rs=1&pid=ImgDetMain",
                    "phhiep999@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia3
            );
            sinhVienRepository.save(sv1);
            sinhVienRepository.save(sv2);
            // insert Lop hoc phan
            LopHocPhan lopHocPhan1 = new LopHocPhan("DHKTPM18B",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 1",
                    1200000,
                    900000,
                    1,
                    3,
                    18,
                    monHoc1
            );
            LopHocPhan lopHocPhan2 = new LopHocPhan("DHKT17A",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 2",
                    800000,
                    900000,
                    1,
                    3,
                    18,
                    monHoc2
            );
            lopHocPhanRepository.save(lopHocPhan1);
            lopHocPhanRepository.save(lopHocPhan2);
            // insert Bang diem
            BangDiem bangDiem1 = new BangDiem(7, 5, 4, 6, 7, TrangThai.DAT,
                    LocalDateTime.of(2023, 5, 14, 0, 0),
                    TrangThaiHocPhi.DA_DONG,
                    sv1,
                    lopHocPhan1
            );
            BangDiem bangDiem2 = new BangDiem(10, 9, 9, 9, 9, TrangThai.DAT,
                    LocalDateTime.of(2022, 7, 14, 0, 0),
                    TrangThaiHocPhi.DA_DONG,
                    sv2,
                    lopHocPhan2
            );
            bangDiemRepository.save(bangDiem1);
            bangDiemRepository.save(bangDiem2);
        };
    }
}