package kr.co.ahaproject.controller.kjs;

import kr.co.ahaproject.dto.CountMachRentDTO;
import org.springframework.ui.Model;


public interface MainController {

    String main(CountMachRentDTO countMachRentDTO, Model model);
    
   
}
