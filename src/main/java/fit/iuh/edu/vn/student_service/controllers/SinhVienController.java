package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.entities.SinhVien;
import fit.iuh.edu.vn.student_service.repositories.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class SinhVienController {
    @Autowired
    public SinhVienRepository sinhVienRepository;

    @GetMapping("/homePage")
    private String homePage() {
        return "Thông tin từ api";
    }

    @GetMapping("/{mssv}")
    private ResponseEntity<SinhVien> getStudentById(@PathVariable Long mssv, @RequestParam String matKhau) {
        Optional<SinhVien> optionalSinhVien = sinhVienRepository.findByMssvAndMatKhau(mssv, matKhau);
        if (optionalSinhVien.isPresent()) {
            SinhVien sinhVien = optionalSinhVien.get();
            return ResponseEntity.ok(sinhVien);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
