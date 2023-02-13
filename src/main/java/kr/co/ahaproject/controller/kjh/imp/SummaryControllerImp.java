package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.SummaryController;
import kr.co.ahaproject.service.kjh.imp.SummaryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting")
public class SummaryControllerImp implements SummaryController {
    @Autowired
    SummaryServiceImp summaryService;
    @Override
    @GetMapping("/summary")
    public String summaryList(Model model) {
        model.addAttribute("ioDTOs", summaryService.selectAll());
        return "user/accounting/summary/list";
    }
}
