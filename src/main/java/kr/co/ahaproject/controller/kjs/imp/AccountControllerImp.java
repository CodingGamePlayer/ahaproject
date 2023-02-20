package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AccountController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.service.kjs.AccountService;
import kr.co.ahaproject.service.kjs.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountControllerImp implements AccountController {

    private final AccountService accountService;
    private final CompanyService companyService;

    @Override
    @GetMapping("/register-form")
    public String registerForm(Model model) {

        List<CompanyDTO> companyDTOS = companyService.selectAll();

        model.addAttribute("companyDTOs", companyDTOS);

        return "sign-up";
    }


    @Override
    @GetMapping("/login-form")
    public String loginForm() {
        return "sign-in";
    }


    @Override
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/login-form";
    }


}