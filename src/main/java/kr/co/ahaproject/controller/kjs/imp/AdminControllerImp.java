package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AdminController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.service.kjs.AccountService;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import kr.co.ahaproject.service.kjs.MisuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControllerImp implements AdminController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ConstructionService constructionService;
    @Autowired
    private MisuService misuService;

    @Autowired
    private AccountService accountService;

    @Override
    @GetMapping("/misu")
    public String misu(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,Model model) {

        PageResponseDTO<Misu> pageResponseDTO = misuService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("misuDTOs", pageResponseDTO);

        return "admin/misu";
    }

    @Override
    public String blacklist() {
        return null;
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
    @GetMapping("/manage-account")
    public String manage(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {

        PageResponseDTO<AccountDTO> pageResponseDTO = accountService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("accountDTOs", pageResponseDTO);

        return "admin/manage-account";
    }


}

