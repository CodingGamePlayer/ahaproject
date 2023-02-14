package kr.co.ahaproject.controller.kjh;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

public interface OutcomeController {

    String selectAll(PageRequestDTO pageRequestDTO, Model model);
    String registerForm(Model model);
    String editForm(long out_id, Model model);

}
