package fit.iuh.edu.vn.student_service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class SinhVienController {
    @GetMapping
    private String homePage(){
        return "index";
    }
}
