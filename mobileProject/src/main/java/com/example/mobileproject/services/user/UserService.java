package com.example.mobileproject.services.user;

import com.example.mobileproject.domain.beans.LoggedUser;
import com.example.mobileproject.domain.dtos.UserLoginDto;
import com.example.mobileproject.domain.dtos.UserRegisterDto;
import com.example.mobileproject.domain.dtos.models.UserModel;
import com.example.mobileproject.domain.entities.User;
import com.example.mobileproject.repositories.UserRepository;
import com.example.mobileproject.repositories.UserRoleRepository;
import com.example.mobileproject.services.role.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRoleService userRoleService;
    private final UserRoleRepository userRoleRepository;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, UserRoleService userRoleService, UserRoleRepository userRoleRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
        this.userRoleRepository = userRoleRepository;
        this.loggedUser = loggedUser;
    }


    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel registerUser(UserRegisterDto userRegisterInfo) {
        final UserModel userModel = this.modelMapper.map(userRegisterInfo, UserModel.class);


        if (userRepository.count() > 0) {
            userModel.setRoles(userRoleService.findAllRoles());
        } else {
            userModel.setRoles(List.of(userRoleService.findRoleByName("USER")));
        }

        final User userToSave = modelMapper.map(userModel, User.class);


        this.userRepository.saveAndFlush(userToSave);

        return this.modelMapper.map(userToSave, UserModel.class);
    }

    public UserModel loginUser(UserLoginDto userLoginDto) {
        Optional<User> loginCandidate = userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());

        UserModel userConfirmation = loginCandidate.isPresent() ? modelMapper.map(loginCandidate.get(), UserModel.class) : new UserModel();

        if (userConfirmation.isValid()) {
            loggedUser.setId(userConfirmation.getId())
                    .setUsername(userConfirmation.getUsername())
                    .setRoleModels(userConfirmation.getRoles());
        }
        return userConfirmation;
    }

    public void logout() {
        this.loggedUser.clearFields();
    }
}
