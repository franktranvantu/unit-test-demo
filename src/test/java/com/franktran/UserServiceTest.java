package com.franktran;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private static final List<User> USERS = List.of(
            new User("Maria", 34),
            new User("Ben", 21)
    );

    @Test
    public void givenMockUserRepository_whenGetYoungUsers_thenEmptyUsers() {
        var userRepository = mock(UserRepository.class);
        var underTest = spy(new UserService(userRepository));

        var result = underTest.getYoungUsers();

        verify(userRepository).getAllUsers();
        assertThat(result).isEmpty();
    }

    @Test
    public void givenMockUserRepositoryAndStubbed_whenGetYoungUsers_thenYoungUsers() {
        var userRepository = mock(UserRepository.class);
        var underTest = spy(new UserService(userRepository));
        when(userRepository.getAllUsers()).thenReturn(USERS);

        var result = underTest.getYoungUsers();

        verify(userRepository).getAllUsers();
        assertThat(result).hasSize(1);
    }

    @Test
    public void givenSpyUserRepository_whenGetYoungUsers_thenReturnYoungUsers() {
        var userRepository = spy(UserRepository.class);
        var underTest = spy(new UserService(userRepository));

        var result = underTest.getYoungUsers();

        verify(userRepository).getAllUsers();
        assertThat(result).hasSize(2);
    }

    @Test
    public void givenSpyUserRepositoryAndStubbed_whenGetYoungUsers_thenReturnYoungUsers() {
        var userRepository = spy(UserRepository.class);
        var underTest = spy(new UserService(userRepository));
        when(userRepository.getAllUsers()).thenReturn(USERS);

        var result = underTest.getYoungUsers();

        verify(userRepository).getAllUsers();
        assertThat(result).hasSize(1);
    }
}
