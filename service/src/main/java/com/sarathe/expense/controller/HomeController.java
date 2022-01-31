package com.sarathe.expense.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String redirect(Principal principal) {
        return "forward:/";
    }

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request){
        SecurityContextHolder.clearContext();
        HttpSession session= request.getSession(false);
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "redirect:/login";
    }

}
