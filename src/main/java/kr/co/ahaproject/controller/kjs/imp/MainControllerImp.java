package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.MainController;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainControllerImp implements MainController {

    private final CalendarService calendarService;
    @Override
    @GetMapping("/")
    public String main(Model model) {

        List<CountMachRentDTO> rentDTOS = calendarService.countRent();

        model.addAttribute("rentDTOs", rentDTOS);

        return "user/main";
    }

}
