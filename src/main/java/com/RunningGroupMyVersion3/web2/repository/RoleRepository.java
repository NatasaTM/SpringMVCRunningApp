package com.RunningGroupMyVersion3.web2.repository;

import com.RunningGroupMyVersion3.web2.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
