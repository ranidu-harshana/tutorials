package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    @PostMapping("/")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        userRepo.save(User.builder()
                .name(userDTO.getName())
                .age(userDTO.getAge())
                .build());

        return userDTO;
    }

    @GetMapping("/")
    public List<UserDTO> allUsers() {
        List<UserDTO> usersD = new ArrayList<>();
        List<User> users = userRepo.findAll();
        for (User user:users) {
            usersD.add(UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .age(user.getAge())
                    .build());
        }

        return usersD;
    }
}
