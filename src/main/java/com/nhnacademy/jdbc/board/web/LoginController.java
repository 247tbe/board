package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.login.service.UserLoginService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {
    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @GetMapping
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) {
        try {
            HttpSession session = request.getSession(false);

            if (!Objects.isNull(session.getAttribute("loginID"))) {
                model.addAttribute("loginID", session);
                String requestURI = request.getRequestURI();
                log.info(requestURI);
                return "redirect:/posts";
            } else {
                return "loginForm";
            }
        } catch (Exception e) {
            return "loginForm";
        }
    }

    @PostMapping
    public String doLogin(@RequestParam("loginID") String loginID,
                          @RequestParam("password") String password,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (!Objects.isNull(userLoginService.login(loginID, password))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loginID", loginID);

            modelMap.put("loginID", loginID);
            return "redirect:/posts";
        } else {
            return "loginForm";
        }
    }
}