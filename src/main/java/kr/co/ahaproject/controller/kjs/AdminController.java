package kr.co.ahaproject.controller.kjs;

import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface AdminController {

    String misu(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);

    String misuForm(Model model);

    String misuEditForm(MisuDTO misuDTO, Model model);

    String blacklist();

    String manage(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);
}
