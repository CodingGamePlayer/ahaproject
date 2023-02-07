package kr.co.ahaproject.controller.moo.imp;

import kr.co.ahaproject.controller.moo.MachineController;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.moo.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MachineControllerImp implements MachineController {
    @Autowired
    private MachineService machineService;

    @Override
    @GetMapping("/machine")
    public String machine(Model model) {
        List<MachineDTO> machineDTOList = machineService.selectAll();

        model.addAttribute("machineDTOs",machineDTOList);
        return "user/machine";
    }

    @Override
    @GetMapping("/basicinfo/machine-form")
    public String machineForm(Model model) {

        List<MachineDTO> machineDTOS = machineService.selectAll();

        

        model.addAttribute("machineDTOs", machineDTOS);
        return "/user/basicinfo/machine/machine-form";
    }
}
