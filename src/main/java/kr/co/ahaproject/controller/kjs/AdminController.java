package kr.co.ahaproject.controller.kjs;

import org.springframework.ui.Model;

public interface AdminController {

    String misu();

    String misuForm(Model model);

    String blacklist();
}
