package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControllerImp implements AdminController {


    @Override
    @GetMapping("/misu")
    public String misu() {
        return "admin/misu";
    }

    @Override
    public String blacklist() {
        return null;
    }

    @Override
    @GetMapping("/misu-form")
    public String misuForm() {
        return "admin/misu-form";
    }
}
