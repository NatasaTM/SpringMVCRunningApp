package com.RunningGroupMyVersion3.web2.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data

public class RegistrationDto {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
