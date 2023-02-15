package kr.co.ahaproject.controller.kjs;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Client;
import org.springframework.validation.BindingResult;

public interface ClientController {

    String client(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);

    String clientForm(Model model,ClientDTO client);

    String clientEditForm(Model model, ClientDTO client);
}
