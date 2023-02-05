package com.example.mobileproject.services.role;

import com.example.mobileproject.domain.entities.UserRole;
import com.example.mobileproject.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }
}
