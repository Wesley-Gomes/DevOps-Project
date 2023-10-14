package com.wesleg.devopsproject.core.usecase;

import java.util.List;

import com.wesleg.devopsproject.core.domain.exception.AlreadyExistsException;
import com.wesleg.devopsproject.core.domain.model.User;
import com.wesleg.devopsproject.core.domain.exception.NotFoundException;
import com.wesleg.devopsproject.core.ports.input.UserCrudInputPort;
import com.wesleg.devopsproject.core.ports.output.UserCrudOutputPort;

public class UserCrudUseCase implements UserCrudInputPort {
    private final UserCrudOutputPort userCrudOutputPort;

    public UserCrudUseCase(UserCrudOutputPort userCrudOutputPort) {
        this.userCrudOutputPort = userCrudOutputPort;
    }

    @Override
    public void save(User user) {
        checkInsert(user);
        userCrudOutputPort.save(user);
    }

    @Override
    public List<User> getList() {
        return userCrudOutputPort.getList();
    }

    @Override
    public User get(String username) {
        return userCrudOutputPort.get(username).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public void updatePassword(String username, String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password is required");
        }
        User user = get(username);
        user.setPassword(password);
        userCrudOutputPort.updatePassword(user);
    }

    @Override
    public void delete(String username) {
        checkDelete(username);
        userCrudOutputPort.delete(username);
    }

    @Override
    public Boolean exists(String username) {
        return userCrudOutputPort.get(username).isPresent();
    }

    private void checkInsert(User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username and password are required");
        }

        if (Boolean.TRUE.equals(exists(user.getUsername()))) {
            throw new AlreadyExistsException("User already exists");
        }
    }

    private void checkDelete(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username is required");
        }

        if (Boolean.FALSE.equals(exists(username))) {
            throw new NotFoundException("User not found");
        }
    }
}
