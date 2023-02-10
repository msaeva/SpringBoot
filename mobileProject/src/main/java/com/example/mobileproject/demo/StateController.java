package com.example.mobileproject.demo;

import com.example.mobileproject.web.BaseController;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class StateController extends BaseController {

    @GetMapping("/register")
    public ModelAndView getRegister(){
        return super.view("demo/register");
    }

    @PostMapping("/register")
    public ModelAndView postRegister(HttpServletResponse response,
                                     @RequestParam(name = "username") String username){
        final Cookie cookie = new Cookie(username,username);
        response.addCookie(cookie);

        return super.redirect("/demo/login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView,
                                 @CookieValue(value = "username", defaultValue = "") String username){

        modelAndView.addObject("username", username);
        return super.view("demo/login", modelAndView);
    }

    //
}
