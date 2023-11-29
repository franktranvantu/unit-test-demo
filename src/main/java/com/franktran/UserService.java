package com.franktran;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getYoungUsers() {
        return userRepository.getAllUsers()
                .stream()
                .filter(user -> user.getAge() < 30)
                .collect(Collectors.toList());
    }
}
