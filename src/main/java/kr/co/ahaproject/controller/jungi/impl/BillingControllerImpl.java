package kr.co.ahaproject.controller.jungi.impl;

import kr.co.ahaproject.controller.jungi.BillingController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Billing;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.service.jungi.BillingService;
import kr.co.ahaproject.service.kjs.ClientService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/basicinfo/billing")
public class BillingControllerImpl implements BillingController {

    private BillingService billingService;
    private ClientService clientService;
    private ConstructionService constructionService;

    @Override
    @GetMapping("/list")
    public String billing(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {

        PageResponseDTO<BillingResponseDTO> pageResponseDTO = billingService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("billingDTOs", pageResponseDTO);

        return "user/billing/list";
    }
    @Override
    @GetMapping("/detail")
    public String billingForm(Model model, BillingDTO billingDTO) {

        return "user/billing/detail";
    }
    @Override
    @GetMapping("/register")
    public String registerForm(Model model) {

        List<ClientDTO> clientDTOs = clientService.selectAll();
        List<ConstructionDTO> constructionDTOs = constructionService.selectAll();
        model.addAttribute("clientDTOs", clientDTOs);
        model.addAttribute("constructionDTOs", constructionDTOs);

        return "user/billing/register";
    }

    @Override
    @GetMapping("/edit")
    public String billingEditForm(Model model, BillingDTO billingDTO) {

        BillingResponseDTO billingResponseDTO =  billingService.findById(billingDTO);
        model.addAttribute("billingResponseDTO", billingResponseDTO);

        return "user/billing/edit";
    }

    @Autowired
    public BillingControllerImpl(BillingService billingService, ClientService clientService, ConstructionService constructionService) {
        this.billingService = billingService;
        this.clientService = clientService;
        this.constructionService = constructionService;
    }
}
