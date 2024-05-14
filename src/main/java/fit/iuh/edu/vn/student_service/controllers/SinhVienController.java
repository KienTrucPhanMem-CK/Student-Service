package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.entities.SinhVien;
import fit.iuh.edu.vn.student_service.repositories.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ResponseEntity<SinhVien> getStudentById(@PathVariable Long mssv) {
        Optional<SinhVien> optionalSinhVien = sinhVienRepository.findByMssv(mssv);
        if (optionalSinhVien.isPresent()) {
            SinhVien sinhVien = optionalSinhVien.get();
            return ResponseEntity.ok(sinhVien);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}