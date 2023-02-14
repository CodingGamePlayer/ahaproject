package kr.co.ahaproject.controller.moo.imp;

import kr.co.ahaproject.controller.moo.LaborCostController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.service.cyr.EmployeeService;
import kr.co.ahaproject.service.kjs.ClientService;
import kr.co.ahaproject.service.moo.LaborCostService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/accounting")
public class LaborCostControllerImp implements LaborCostController {
    @Autowired
    private LaborCostService laborCostService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    private ClientService clientService;

    // 인건비 전체보기
    @Override
    @GetMapping("/laborcost")
    public String list(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<LaborCostListDTO> pageResponseDTO = laborCostService.selectAllForPaging(pageRequestDTO);

        model.addAttribute("laborCostDTOs",pageResponseDTO);
        return "user/accounting/laborcost/list";
    }

    // 인건비 삭제하기
    @Override
    public String delete(Model model) {
        return null;
    }

    // 인건비 등록하기
    @Override
    @GetMapping("/laborcost/register")
    public String register(Model model) {
        List<Employee> employeeDTOList = employeeService.listAll();
        List<ConstructionDTO> constructionDTOList = constructionService.selectAll();
        List<ClientDTO> clientDTOList =clientService.selectAll();


        model.addAttribute("employeeDTOs", employeeDTOList);
        model.addAttribute("constructionDTOs", constructionDTOList);
        model.addAttribute("clientDTOs", clientDTOList);

        return "user/accounting/laborcost/register";
    }

    // 인건비 수정하기
    @Override
    @GetMapping("/laborcost/update")
    public String update(LaborCostDTO laborCostDTO, Model model) {
        LaborCostDTO result = laborCostService.findById(laborCostDTO);
        List<Employee> employeeDTOList = employeeService.listAll();
        List<ConstructionDTO> constructionDTOList = constructionService.selectAll();
        List<ClientDTO> clientDTOList =clientService.selectAll();

        model.addAttribute("LaborCost", result);
        model.addAttribute("employeeDTOs", employeeDTOList);
        model.addAttribute("constructionDTOs", constructionDTOList);
        model.addAttribute("clientDTOs", clientDTOList);
        return "user/accounting/laborcost/update";
    }
}
