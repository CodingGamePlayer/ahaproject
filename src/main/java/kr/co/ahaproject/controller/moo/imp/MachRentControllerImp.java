package kr.co.ahaproject.controller.moo.imp;

import kr.co.ahaproject.controller.moo.MachRentController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.service.moo.MachRentService;
import kr.co.ahaproject.service.moo.MachineService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
    public String list(@Valid PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<MachRentListDTO> pageResponseDTO = machRentService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("machRentDTOs", pageResponseDTO);
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
