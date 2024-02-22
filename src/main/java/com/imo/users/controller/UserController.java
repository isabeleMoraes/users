package com.imo.users.controller;

import com.imo.users.model.User;
import com.imo.users.service.UserService;
import com.imo.users.vo.UserVo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid UserVo userVo ){
        User user = userVo.toModel();
        userService.createUser(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UserVo userVo){
        User user = userVo.toModel();
        userService.updateUser(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody @Valid UserVo userVo){
        User user = userVo.toModel();
        userService.deleteUser(user);
    }

    public List<User> getAll(){
        return userService.findAll();
    }
}
