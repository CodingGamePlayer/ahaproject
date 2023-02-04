package kr.co.ahaproject.controller.kjs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AccountController {

    String registerForm();
    String loginForm();
    String logout(HttpServletRequest request, HttpServletResponse response);




}
