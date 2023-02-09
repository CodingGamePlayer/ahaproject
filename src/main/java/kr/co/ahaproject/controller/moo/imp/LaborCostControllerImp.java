package kr.co.ahaproject.controller.moo.imp;

import kr.co.ahaproject.controller.moo.LaborCostController;
import kr.co.ahaproject.dto.LaborCostDTO;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.moo.LaborCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/accounting")
public class LaborCostControllerImp implements LaborCostController {
    @Autowired
    private LaborCostService laborCostService;
    // 인건비 보기
    @Override
    @GetMapping("/laborcost")
    public String list(Model model) {
        List<LaborCostDTO> laborCostDTOList = laborCostService.selectAll();

        model.addAttribute("laborCostDTOs",laborCostDTOList);
        return "/user/accounting/laborcost/list";
    }

    @Override
    public String register(Model model) {
        return null;
    }

    @Override
    public String update(Model model) {
        return null;
    }
}
