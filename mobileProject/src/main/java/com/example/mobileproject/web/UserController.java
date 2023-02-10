package com.example.mobileproject.web;

import com.example.mobileproject.domain.dtos.UserLoginDto;
import com.example.mobileproject.domain.dtos.UserRegisterDto;
import com.example.mobileproject.domain.dtos.views.UserRoleViewDto;
import com.example.mobileproject.domain.entities.UserRole;
import com.example.mobileproject.services.role.UserRoleService;
import com.example.mobileproject.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView getRegister( ModelAndView modelAndView) {
        List<UserRoleViewDto> roles = roleService.getAll();
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("auth-register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView getRegister(@Valid UserRegisterDto userRegisterInfo) {

        userService.registerUser(userRegisterInfo);

        return super.redirect("/users/login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView getLogin(@RequestParam UserLoginDto userLoginDto) {
        //userService.login(userLoginDto.getUsername(), userLoginDto.getPassword());

        return super.redirect("auth-login");
    }
}
