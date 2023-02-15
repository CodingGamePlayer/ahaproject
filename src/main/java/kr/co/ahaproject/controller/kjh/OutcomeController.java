package kr.co.ahaproject.controller.kjh;

import org.springframework.ui.Model;

public interface OutcomeController {

    String selectAll(Model model);
    String registerForm(Model model);
    String editForm(long out_id, Model model);

}
