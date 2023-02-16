package kr.co.ahaproject.controller.jungi;

import kr.co.ahaproject.dto.BillingDTO;
import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface BillingController {

    String registerForm(Model model);
    String billing(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);
    String billingForm(Model model, BillingDTO billingDTO);
    String billingEditForm(Model model, BillingDTO billingDTO);
}
