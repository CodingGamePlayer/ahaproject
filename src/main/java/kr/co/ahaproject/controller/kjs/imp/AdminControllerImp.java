package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AdminController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.service.kjs.*;
import kr.co.ahaproject.service.mskim.ConstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminControllerImp implements AdminController {


    private final CompanyService companyService;

    private final ConstructionService constructionService;

    private final MisuService misuService;

    private final AccountService accountService;

    private final BlackService blackService;

    private final ClientService clientService;


    @Override
    @GetMapping("/misu")
    public String misu(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,Model model) {

        PageResponseDTO<Misu> pageResponseDTO = misuService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("misuDTOs", pageResponseDTO);

        return "admin/misu";
    }

    @Override
    @GetMapping("/manage-black")
    public String blacklist(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<BlackListDTO> pageResponseDTO = blackService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("blacklist", pageResponseDTO);

        return "admin/manage-black";
    }

    @Override
    @GetMapping("/black-form")
    public String blackForm(Model model) {

        List<CompanyDTO> companyDTOS = companyService.selectAll();
        List<ClientDTO> clientDTOS = clientService.selectAll();

        model.addAttribute("companies", companyDTOS);
        model.addAttribute("clients", clientDTOS);

        return "admin/black-form";
    }

    @Override
    @GetMapping("/misu-form")
    public String misuForm(Model model) {

        List<CompanyDTO> companyDTOS = companyService.selectAll();
        List<ConstructionDTO> constructionDTOS = constructionService.selectAll();

        model.addAttribute("companyDTOs", companyDTOS);
        model.addAttribute("constructionDTOs", constructionDTOS);


        return "admin/misu-form";
    }

    @Override
    @GetMapping("/misu-edit")
    public String misuEditForm(MisuDTO misuDTO, Model model) {

        MisuDTO result = misuService.findById(misuDTO);
        List<CompanyDTO> companyDTOS = companyService.selectAll();
        List<ConstructionDTO> constructionDTOS = constructionService.selectAll();

        model.addAttribute("misuDTO", result);
        model.addAttribute("companyDTOs", companyDTOS);
        model.addAttribute("constructionDTOs", constructionDTOS);
        return "admin/misu-edit-form";
    }

    @Override
    @GetMapping("/misu/image")
    public String misuImage(MisuDTO misuDTO, Model model) {

        MisuDTO result = misuService.findById(misuDTO);

        model.addAttribute("misuDTO", result);


        return "admin/image";
    }

    @Override
    @GetMapping("/manage-account")
    public String manage(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {

        PageResponseDTO<AccountListDTO> pageResponseDTO = accountService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("accountDTOs", pageResponseDTO);

        return "admin/manage-account";
    }




}

