package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.MainController;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainControllerImp implements MainController {

    private final CalendarService calendarService;
    private String kind;
    @Override
    @GetMapping("/")
    public String main(Model model) {

        kind = "장비";
        CountMachRentDTO jangbiDTO = calendarService.countRent(kind);
        kind = "포장";
        CountMachRentDTO pojangDTO = calendarService.countRent(kind);


        model.addAttribute("jangBi", jangbiDTO);
        model.addAttribute("poJang", pojangDTO);

        return "user/main";
    }

}
