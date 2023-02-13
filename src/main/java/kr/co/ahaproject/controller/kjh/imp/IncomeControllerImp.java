package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.IncomeController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting")
public class IncomeControllerImp implements IncomeController {
    @Autowired
    IncomeService incomeService;

    @Override
    @GetMapping("/income")
    public String selectAll(Model model) {
        model.addAttribute("ioDTOs", incomeService.selectAll());
        return "user/accounting/income/list";
    }

    @Override
    public String selectOne(int id, Model model) {
        return null;
    }

    @Override
    @GetMapping("/income-form")
    public String registerForm(Model model) {
        //회사, 거래처, 공사 서비스
        return "user/accounting/income/form";
    }


    @Override
    @GetMapping("/income-edit")
    public String editForm(long io_id, Model model) {
        model.addAttribute("ioDTO", incomeService.selectOne( io_id));
        //회사, 거래처, 공사 서비스
        return "user/accounting/income/edit-form";
    }


//    @GetMapping("/test")
//    public String test1(IncomeOutcomeDTO ioDTO, Model model) {
//        IncomeOutcomeDTO ioDTO1 = incomeService.selectRecent(ioDTO);
//        System.out.println(ioDTO1.getIo_id());
//        // gkgkgk
//        if(ioDTO1.getIo_id()==null) {
//            ioDTO.setIn_total_value(ioDTO.getIn_supp_value());
//            ioDTO.setIn_collect_remain(ioDTO.getIn_supp_value() - ioDTO.getIn_collect_value());
//        } else {
//            ioDTO.setIn_total_value(ioDTO1.getIn_total_value()+ioDTO.getIn_supp_value());
//            ioDTO.setIn_collect_remain(ioDTO1.getIn_collect_remain()+ioDTO.getIn_supp_value()-ioDTO.getIn_collect_value());
//        }
//        return "user/accounting/income/test";
//    }


}

