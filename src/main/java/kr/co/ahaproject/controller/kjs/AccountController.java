package kr.co.ahaproject.controller.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface AccountController {

    String registerForm();
    String register(AccountDTO accountDTO) throws UnsupportedEncodingException;

    String loginForm();
    String logout(HttpServletRequest request, HttpServletResponse response);



}
