package com.example.mobileproject.web;

import com.example.mobileproject.domain.dtos.UserLoginDto;
import com.example.mobileproject.domain.dtos.UserRegisterDto;
import com.example.mobileproject.domain.dtos.views.UserRoleViewDto;
import com.example.mobileproject.services.role.UserRoleService;
import com.example.mobileproject.services.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final UserRoleService roleService;
    private final UserService userService;

    public UserController(UserRoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        List<UserRoleViewDto> roles = roleService.getAll();

        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@Valid UserRegisterDto userRegisterInfo, HttpServletRequest request) {
        userService.registerUser(userRegisterInfo);
        return super.redirect("/users/login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView postLogin(UserLoginDto userLoginDto) {
        return userService.loginUser(userLoginDto).isValid()
                ? super.redirect("/")
                : super.redirect("/users/register");
    }

    @PostMapping("/logout")
    public ModelAndView logout() {
        userService.logout();
        return super.redirect("/");
    }
}
