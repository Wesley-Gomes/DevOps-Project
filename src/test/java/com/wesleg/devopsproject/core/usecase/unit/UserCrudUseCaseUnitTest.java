package com.wesleg.devopsproject.core.usecase.unit;

import com.wesleg.devopsproject.core.domain.model.User;
import com.wesleg.devopsproject.core.ports.output.UserCrudOutputPort;
import com.wesleg.devopsproject.core.usecase.UserCrudUseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("User Crud Use Case Unit Test")
class UserCrudUseCaseUnitTest {
    private static UserCrudUseCase crudUserUseCase;

    @Mock
    private static UserCrudOutputPort userCrudOutputPort;


    @BeforeAll
    static void setUp() {
        userCrudOutputPort = mock(UserCrudOutputPort.class);
        crudUserUseCase = new UserCrudUseCase(userCrudOutputPort);
    }

    @Test
    @DisplayName("Save User")
    void createUser() {
        User user = generateUser();

        when(userCrudOutputPort.get(user.getUsername())).thenReturn(Optional.empty());
        doNothing().when(userCrudOutputPort).save(user);

        crudUserUseCase.save(user);

        verify(userCrudOutputPort, times(1)).save(user);
    }

    @Test
    @DisplayName("Get Users")
    void getUsers() {
        List<User> users = List.of(generateUser(), generateUser(), generateUser());

        when(userCrudOutputPort.getList()).thenReturn(users);

        List<User> usersResponse = crudUserUseCase.getList();

        assertEquals(users, usersResponse);
        verify(userCrudOutputPort, times(1)).getList();
    }

    @Test
    @DisplayName("Get User")
    void getUser() {
        User user = generateUser();

        when(userCrudOutputPort.get(user.getUsername())).thenReturn(Optional.of(user));

        User userResponse = crudUserUseCase.get(user.getUsername());

        assertEquals(user, userResponse);
    }

    @Test
    @DisplayName("Update User Password")
    void updateUser() {
        User user = generateUser();

        when(userCrudOutputPort.get(user.getUsername())).thenReturn(Optional.of(user));
        doNothing().when(userCrudOutputPort).updatePassword(user);

        crudUserUseCase.updatePassword("username", "password1");

        verify(userCrudOutputPort, times(1)).updatePassword(user);
    }

    @Test
    @DisplayName("Delete User")
    void deleteUser() {
        User user = generateUser();

        when(userCrudOutputPort.get(user.getUsername())).thenReturn(Optional.of(user));
        doNothing().when(userCrudOutputPort).delete(user.getUsername());

        crudUserUseCase.delete(user.getUsername());

        verify(userCrudOutputPort, times(1)).delete(user.getUsername());
    }

    private User generateUser() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        return user;
    }
}
