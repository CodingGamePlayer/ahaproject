package kr.co.ahaproject.controller.kjs.imp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.kjs.MainController;


@Controller
public class MainControllerImp implements MainController {

    @Override
    @GetMapping("/")
    public String main() {
        return "user/main";
    }

}
