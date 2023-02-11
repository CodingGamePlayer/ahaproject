package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.SummaryController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting")
public class SummaryControllerImp implements SummaryController {

    @Override
    @GetMapping("/summary")
    public String summaryList() {
        //income,outcome service.selectAll
        return "user/accounting/summary/list";
    }
}
