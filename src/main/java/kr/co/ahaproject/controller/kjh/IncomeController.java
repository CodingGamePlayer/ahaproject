package kr.co.ahaproject.controller.kjh;

import org.springframework.ui.Model;

public interface IncomeController {

    public String selectAll(Model model);
    public String selectOne(int id, Model model);
    public String registerForm();
    public String editForm(int id, Model model);
    public String delete(int id);
}
