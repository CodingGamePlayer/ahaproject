package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.MachRentController;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.mskim.ConstructionService;
import kr.co.ahaproject.service.kjs.MachRentService;
import kr.co.ahaproject.service.kjs.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/worksite")
public class MachRentControllerImp implements MachRentController {

    @Autowired
    private MachRentService machRentService;

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    private MachineService machineService;

    // 장비임대 보기
    @Override
    @GetMapping("/rental")
    public String list(Model model) {
        List<MachRentListDTO> machRentListDTOS = machRentService.selectAllForList();

        model.addAttribute("machRentDTOs",machRentListDTOS);
        return "user/worksite/rental/list";
    }
    
    // 장비임대 입력
    @Override
    @GetMapping("/rental/register")
    public String register(Model model) {

        List<ConstructionDTO> constructionDTOS = constructionService.selectAll();
        List<MachineDTO> machineDTOS = machineService.selectAll();

        model.addAttribute("constructionDTOs", constructionDTOS);
        model.addAttribute("machineDTOs", machineDTOS);

        return "user/worksite/rental/register";
    }

    // 장비임대 수정
    @Override
    @GetMapping("/rental/update")
    public String update(MachRentDTO machRentDTO, Model model) {
        MachRentDTO result = machRentService.findById(machRentDTO);
        List<ConstructionDTO> constructionDTOS = constructionService.selectAll();
        List<MachineDTO> machineDTOS = machineService.selectAll();

        model.addAttribute("machRent", result);
        model.addAttribute("constructionDTOs", constructionDTOS);
        model.addAttribute("machineDTOs", machineDTOS);
        return "user/worksite/rental/update";
    }
}
