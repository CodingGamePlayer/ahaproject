package kr.co.ahaproject.controller.kjs;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.MisuDTO;

public interface ClientController {

    String client(Model model);

    String clientForm(Model model);

    String clientEditForm(MisuDTO misuDTO, Model model);
}
