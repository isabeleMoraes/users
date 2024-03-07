package com.imo.users.vo;

import com.imo.users.model.User;
import jakarta.validation.constraints.NotEmpty;

import java.util.Random;


public class UserVo {
    @NotEmpty
    private String name;
    private String email;
    private String password;
    private String cpf;

    public User toModel() {
        Random random = new Random();
        Long id = random.nextLong();
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .cpf(cpf)
                .build();
    }
}
