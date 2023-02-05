package com.example.mobileproject.services.init;

import com.example.mobileproject.domain.entities.UserRole;
import com.example.mobileproject.domain.enums.Role;
import com.example.mobileproject.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseInitImpl implements DataBaseInitService {
    private final UserRoleRepository userRoleRepository;

    public DataBaseInitImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.dbInit();
    }

    @Override
    public boolean isDbInit() {
        return userRoleRepository.count() > 0;
    }

    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<UserRole> roles = new ArrayList<>();

            roles.add(new UserRole().setRole(Role.USER));
            roles.add(new UserRole().setRole(Role.ADMIN));

            userRoleRepository.saveAllAndFlush(roles);
        }
    }
}
