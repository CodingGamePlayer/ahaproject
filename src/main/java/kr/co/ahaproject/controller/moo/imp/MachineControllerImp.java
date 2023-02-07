package kr.co.ahaproject.controller.moo.imp;

import kr.co.ahaproject.controller.moo.MachineController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MachineControllerImp implements MachineController {


    @Override
    @GetMapping("/basicinfo/machine-form")
    public String machineForm(Model model) {
        return "/user/basicinfo/machine/machine-form";
    }
}
