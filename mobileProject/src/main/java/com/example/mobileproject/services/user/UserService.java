package com.example.mobileproject.services.user;

import com.example.mobileproject.domain.dtos.UserRegisterDto;
import com.example.mobileproject.domain.dtos.models.UserModel;
import com.example.mobileproject.domain.dtos.models.UserRoleModel;
import com.example.mobileproject.domain.entities.User;
import com.example.mobileproject.domain.enums.Role;
import com.example.mobileproject.repositories.UserRepository;
import com.example.mobileproject.repositories.UserRoleRepository;
import com.example.mobileproject.services.role.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRoleService userRoleService;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, UserRoleService userRoleService, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
        this.userRoleRepository = userRoleRepository;
    }


    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel registerUser(UserRegisterDto userRegisterInfo) {
        final UserModel userModel = this.modelMapper.map(userRegisterInfo, UserModel.class);


        if (userRepository.count() > 0) {
            userModel.setRole(userRoleService.findAllRoles());
        } else {
            userModel.setRole(List.of(userRoleService.findRoleByName("USER")));
        }

       final User userToSave = modelMapper.map(userModel, User.class);


        this.userRepository.saveAndFlush(userToSave);

        return this.modelMapper.map(userToSave, UserModel.class);
    }

//    public void login(String username, String password) {
//        if ()
//        userRepository.findByUsernameAndPassword(username, password);
//    }
}
