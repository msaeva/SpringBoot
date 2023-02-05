package com.example.mobileproject.web;

import com.example.mobileproject.domain.dtos.UserRegisterDto;
import com.example.mobileproject.domain.entities.UserRole;
import com.example.mobileproject.services.role.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final UserRoleService roleService;

    public UserController(UserRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        List<UserRole> roles = roleService.getAll();
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("auth-register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestBody UserRegisterDto dto) {

        return super.redirect("http://localhost:8080/users/login");
    }
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }
}
