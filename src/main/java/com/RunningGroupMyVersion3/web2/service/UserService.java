package com.RunningGroupMyVersion3.web2.service;

import com.RunningGroupMyVersion3.web2.models.RegistrationDto;
import com.RunningGroupMyVersion3.web2.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
