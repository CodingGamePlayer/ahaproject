package kr.co.ahaproject.controller.moo;

import kr.co.ahaproject.dto.LaborCostDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface LaborCostController {
    // 인건비 보기
    String list(Model model);

   // 인건비 삭제하기
    String delete(Model model);

    // 인건비 입력
    String register(Model model);

    // 인건비 수정
    String update(LaborCostDTO laborCostDTO, Model model);
}
