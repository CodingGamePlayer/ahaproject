package kr.co.ahaproject.controller.moo;

import kr.co.ahaproject.dto.MachineDTO;
import org.springframework.ui.Model;

public interface MachineController {
    // 장비정보 보기
    String list(Model model);
    
    // 장비정보 입력
    String register(Model model);

    // 장비정보 수정
    String update(MachineDTO machineDTO, Model model);
}
