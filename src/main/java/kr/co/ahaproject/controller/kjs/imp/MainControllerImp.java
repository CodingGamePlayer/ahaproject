package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.MainController;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainControllerImp implements MainController {

    private final CalendarService calendarService;
    private String kind;
    @Override
    @GetMapping("/")
    public String main(CountMachRentDTO countMachRentDTO, Model model) {
        String requestYear = countMachRentDTO.getYear();
        String thisYear = String.valueOf(LocalDate.now()).substring(0,4);

        if(requestYear == null){
            requestYear = thisYear;
        }

        kind = "장비";
        CountMachRentDTO jangbiDTO = calendarService.countRent(requestYear, kind);
        kind = "포장";
        CountMachRentDTO pojangDTO = calendarService.countRent(requestYear, kind);
        if (jangbiDTO == null && pojangDTO == null){
            CountMachRentDTO jangbiDTO1 = makeEmpty();
            CountMachRentDTO pojangDTO1 = makeEmpty();


            model.addAttribute("jangBi", jangbiDTO1);
            model.addAttribute("poJang", pojangDTO1);
        } else if (jangbiDTO == null) {
            CountMachRentDTO jangbiDTO1 = makeEmpty();

            model.addAttribute("jangBi", jangbiDTO1);
            model.addAttribute("poJang", pojangDTO);
        } else if (pojangDTO == null) {
            CountMachRentDTO pojangDTO1 = makeEmpty();

            model.addAttribute("jangBi", jangbiDTO);
            model.addAttribute("poJang", pojangDTO1);
        } else {
            model.addAttribute("jangBi", jangbiDTO);
            model.addAttribute("poJang", pojangDTO);
        }


        return "user/main";
    }

    private CountMachRentDTO makeEmpty () {
        return new CountMachRentDTO();
    }
    
}
