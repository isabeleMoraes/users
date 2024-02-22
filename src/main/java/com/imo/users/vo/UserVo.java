package com.imo.users.vo;

import com.imo.users.model.User;


public class UserVo {
    private String name;
    private String email;
    private String password;
    private String cpf;

    public User toModel() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .cpf(cpf)
                .build();
    }
}
