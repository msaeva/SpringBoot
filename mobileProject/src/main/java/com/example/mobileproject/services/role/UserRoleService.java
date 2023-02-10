package com.example.mobileproject.services.role;

import com.example.mobileproject.domain.dtos.models.UserRoleModel;
import com.example.mobileproject.domain.dtos.views.UserRoleViewDto;
import com.example.mobileproject.domain.entities.UserRole;
import com.example.mobileproject.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    public UserRoleService(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserRoleViewDto> getAll() {
        return userRoleRepository.findAll().stream()
                .map(role -> modelMapper.map(role , UserRoleViewDto.class))
                .collect(Collectors.toList());
    }

    public List<UserRoleModel> findAllRoles() {
       return userRoleRepository.findAll().stream()
               .map(role -> modelMapper.map(role, UserRoleModel.class))
               .collect(Collectors.toList());

    }


    public UserRoleModel findRoleByName(String name) {
        UserRole userRole = this.userRoleRepository.findByRole(name).
                orElseThrow(NoSuchElementException::new);

        return this.modelMapper.map(userRole, UserRoleModel.class);
    }

}
