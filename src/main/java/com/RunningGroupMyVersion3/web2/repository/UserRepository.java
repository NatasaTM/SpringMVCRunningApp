package com.RunningGroupMyVersion3.web2.repository;

import com.RunningGroupMyVersion3.web2.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);

   UserEntity findFirstByUsername(String username);
}
