package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AccountController;
import kr.co.ahaproject.mapper.kjs.AccountMapper;
import kr.co.ahaproject.service.kjs.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class AccountControllerImp implements AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @GetMapping("/register-form")
    public String registerForm() {
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

        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }

        return "redirect:/login-form";
    }
}
