package kr.co.ahaproject.controller.kjs;

import kr.co.ahaproject.dto.MachRentDTO;
import org.springframework.ui.Model;

public interface MachRentController {
    // 장비임대 보기
    String list(Model model);

    // 장비임대 입력
    String register(Model model);

    // 장비임대 수정
    String update(MachRentDTO machRentDTO, Model model);
}
