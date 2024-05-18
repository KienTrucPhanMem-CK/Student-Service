package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.dtos.BangDiem_DTO;
import fit.iuh.edu.vn.student_service.entities.BangDiem;

public interface BangDiemService {
    BangDiem taoBangDiem(BangDiem bangDiem) throws Exception;
}
