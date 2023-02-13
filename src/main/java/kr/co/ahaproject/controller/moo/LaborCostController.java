package kr.co.ahaproject.controller.moo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

public interface LaborCostController {
    // 인건비 보기
    String list(Model model);

    @PostMapping("/laborCost")
    String delete(Model model);

    // 인건비 입력
    String register(Model model);

    // 인건비 수정
    String update(Model model);
}
