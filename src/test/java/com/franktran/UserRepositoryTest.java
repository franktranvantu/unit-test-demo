package com.franktran;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {
    private UserRepository underTest = new UserRepository();

    @Test
    public void givenUsers_whenGetYoungUser_thenReturnYoungUsers() {
        var result = underTest.getAllUsers();
        assertThat(result).hasSize(3);
    }
}
