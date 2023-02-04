package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AdminController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.kjs.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControllerImp implements AdminController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ConstructionService constructionService;

    @Override
    @GetMapping("/misu")
    public String misu() {
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
}
