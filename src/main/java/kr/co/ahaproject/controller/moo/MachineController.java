package kr.co.ahaproject.controller.moo;

import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface MachineController {
    // 장비정보 보기
    String list(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);
    
    // 장비정보 입력
    String register(Model model);

    // 장비정보 수정
    String update(MachineDTO machineDTO, Model model);

    String image(MachineDTO machineDTO, Model model);

}
