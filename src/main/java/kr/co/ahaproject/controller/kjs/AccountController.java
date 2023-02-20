package kr.co.ahaproject.controller.kjs;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AccountController {

    String registerForm(Model model);
    String loginForm();
    String logout(HttpServletRequest request, HttpServletResponse response);





}
