package com.example.mobileproject.repositories;

import com.example.mobileproject.domain.entities.UserRole;
import com.example.mobileproject.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRole(String name);
}
