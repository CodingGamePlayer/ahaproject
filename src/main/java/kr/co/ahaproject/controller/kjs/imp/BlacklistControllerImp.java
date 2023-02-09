package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.BlacklistController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class BlacklistControllerImp implements BlacklistController {



    @Override
    public String list(Model model) {
        return null;
    }
}
