package kr.co.ahaproject.controller.moo.imp;

import kr.co.ahaproject.controller.moo.MachineController;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.service.moo.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MachineControllerImp implements MachineController {
    @Autowired
    private MachineService machineService;

    // 장비정보 보기
    @Override
    @GetMapping("/machine")
    public String list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {


        PageResponseDTO<MachineDTO> pageResponseDTO = machineService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("machineDTOs",pageResponseDTO);

        return "user/basicinfo/machine/list";
    }

    // 장비정보 입력
    @Override
    @GetMapping("/basicinfo/register")
    public String register(Model model) {

        List<MachineDTO> machineDTOS = machineService.selectAll();
        int new_m_code = Integer.parseInt(String.valueOf(machineService.getm_code()+1));


        String str = String.format("%04d", new_m_code);

        model.addAttribute("machineDTOs", machineDTOS);
        model.addAttribute("m_code", str);
        return "user/basicinfo/machine/register";
    }

    // 장비정보 수정
    @Override
    @GetMapping("/basicinfo/update")
    public String update(MachineDTO machineDTO, Model model){

        MachineDTO result = machineService.findById(machineDTO);

        model.addAttribute("machine", result);

        return "user/basicinfo/machine/update";
    }

    @Override
    @GetMapping("/basicinfo/machine/image")
    public String image(MachineDTO machineDTO, Model model) {

        MachineDTO result = machineService.findById(machineDTO);

        model.addAttribute("machineDTO", result);
        return "user/basicinfo/machine/image";
    }



}
