package com.nhnacademy.jdbc.board.interceptor;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if (!Objects.isNull(session.getAttribute("adminLogin")) ||
            !Objects.isNull(session.getAttribute("userLogin"))) {
            return true;
        } else {
            response.sendRedirect("/");
            return false;
        }
    }
}
