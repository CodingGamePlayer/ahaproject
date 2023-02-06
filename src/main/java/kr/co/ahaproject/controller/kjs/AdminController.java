package kr.co.ahaproject.controller.kjs;

import kr.co.ahaproject.dto.MisuDTO;
import org.springframework.ui.Model;

public interface AdminController {

    String misu(Model model);

    String misuForm(Model model);

    String misuEditForm(MisuDTO misuDTO, Model model);

    String blacklist();
}
