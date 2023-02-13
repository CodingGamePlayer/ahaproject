package kr.co.ahaproject.controller.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface IncomeController {

    String selectAll(Model model);
    String registerForm(Model model);
    String editForm(long io_id, Model model);
}
