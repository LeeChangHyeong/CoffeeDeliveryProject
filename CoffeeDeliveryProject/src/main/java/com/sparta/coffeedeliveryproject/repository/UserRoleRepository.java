package com.sparta.coffeedeliveryproject.repository;

import com.sparta.coffeedeliveryproject.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByRole(String user);

}
