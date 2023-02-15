package kr.co.ahaproject.controller.kjh;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

public interface SummaryController {

    String summaryList(PageRequestDTO pageRequestDTO, Model model);
}
