package kr.co.ahaproject.controller.moo;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

public interface MachRentController {
    // 장비임대 보기
    String list(PageRequestDTO pageRequestDTO, Model model);

    // 장비임대 입력
    String register(Model model);

    // 장비임대 수정
    String update(MachRentDTO machRentDTO, Model model);
}
