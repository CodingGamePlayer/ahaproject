package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.AccountController;
import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.entity.Account;
import kr.co.ahaproject.mapper.kjs.AccountMapper;
import kr.co.ahaproject.service.kjs.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    @PostMapping("/register")
    public String register(AccountDTO accountDTO) throws UnsupportedEncodingException {

        String msg = "회원가입이 완료되었습니다.";

        int result = accountService.register(accountDTO);


        if (result == 0 ) {
            msg = "서버에 문제가 발생하였습니다.";
            String encode = URLEncoder.encode(msg, "UTF-8");
            return "redirect:/register-form?error=true&msg=" + encode;
        }

        String encode = URLEncoder.encode(msg, "UTF-8");

        return "redirect:/login-form?msg=" + encode;
    }

    @Override
    @GetMapping("/login-form")
    public String loginForm() {
        return "sign-in";
    }


}
