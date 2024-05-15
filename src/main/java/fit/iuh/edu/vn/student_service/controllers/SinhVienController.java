package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.entities.SinhVien;
import fit.iuh.edu.vn.student_service.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class SinhVienController {

    private final SinhVienService sinhVienService;

    @Autowired
    public SinhVienController(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }

    @GetMapping("/homePage")
    private String homePage() {
        return "Thông tin từ api";
    }

    @GetMapping("/getStudent")
    private ResponseEntity<SinhVien> getStudentById(@RequestParam Long mssv, @RequestParam String matKhau) {
        Optional<SinhVien> optionalSinhVien = sinhVienService.findSinhVienByMssvAndMatkhau(mssv, matKhau);
        if (optionalSinhVien.isPresent()) {
            SinhVien sinhVien = optionalSinhVien.get();
            return ResponseEntity.ok(sinhVien);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
