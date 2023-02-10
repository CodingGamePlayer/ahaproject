package kr.co.ahaproject.controller.kjh;

import org.springframework.ui.Model;

public interface IncomeController {

    public String selectAll(Model model);
    public String registerForm(Model model);
    public String editForm(long io_id, Model model);

}
