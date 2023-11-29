package com.franktran;

import java.util.List;

public class UserRepository {
    public List<User> getAllUsers() {
        return List.of(
                new User("Tu", 30),
                new User("Ho", 27),
                new User("Thoi", 25)
        );
    }
}
