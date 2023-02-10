package kr.co.ahaproject.controller.moo;

import org.springframework.ui.Model;

public interface LaborCostController {
    // 인건비 보기
    String list(Model model);

    // 인건비 입력
    String register(Model model);

    // 인건비 수정
    String update(Model model);
}
