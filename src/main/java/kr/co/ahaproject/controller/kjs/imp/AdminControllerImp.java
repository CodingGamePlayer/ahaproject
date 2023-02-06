package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AdminController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.kjs.ConstructionService;
import kr.co.ahaproject.service.kjs.MisuService;
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

    @Autowired
    private MisuService misuService;

    @Override
    @GetMapping("/misu")
    public String misu(Model model) {

        List<MisuDTO> misuDTOList = misuService.selectAll();

        model.addAttribute("misuDTOs", misuDTOList);

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
}
