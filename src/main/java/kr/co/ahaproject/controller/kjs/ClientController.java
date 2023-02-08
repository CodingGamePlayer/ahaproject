package kr.co.ahaproject.controller.kjs;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Client;

public interface ClientController {

    String client(Model model);

    String clientForm(Model model,ClientDTO client);

    String clientEditForm(Model model, ClientDTO client);
}
