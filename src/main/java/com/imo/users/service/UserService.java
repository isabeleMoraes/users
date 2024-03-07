package com.imo.users.service;

import com.imo.users.model.User;
import com.imo.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user){
        if(userRepository.existsByCpf(user.getCpf())){
            throw new IllegalArgumentException("User already exists");
        }
        userRepository.save(user);
    }

    public void updateUser(User user){
        Optional<User> opUser = userRepository.getByCpf(user.getCpf());

        if(!opUser.isPresent()){
            throw new IllegalArgumentException("User not found");
        }

        user.setId(opUser.get().getId());

        userRepository.save(user);
    }

    public void deleteUser(User user){
        if(!userRepository.existsByCpf(user.getCpf())){
            throw new IllegalArgumentException("User not found");
        }
        userRepository.delete(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
