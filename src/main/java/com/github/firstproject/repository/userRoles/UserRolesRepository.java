package com.github.firstproject.repository.userRoles;

import com.github.firstproject.entity.userRole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRole, Long> {
}
