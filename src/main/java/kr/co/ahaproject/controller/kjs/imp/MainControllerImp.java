package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.MainController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerImp implements MainController {

    @Override
    @GetMapping("/")
    public String main() {
        return "main";
    }


}
