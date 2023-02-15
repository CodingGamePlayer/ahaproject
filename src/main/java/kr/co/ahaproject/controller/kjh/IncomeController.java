package kr.co.ahaproject.controller.kjh;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

public interface IncomeController {

    String selectAll(PageRequestDTO pageRequestDTO, Model model);
    String registerForm(Model model);
    String editForm(long in_id, Model model);
}
