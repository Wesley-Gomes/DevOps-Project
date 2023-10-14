package com.wesleg.devopsproject.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wesleg.devopsproject.adapters.in.controller.mappers.UserMapper;
import com.wesleg.devopsproject.adapters.in.controller.request.UserRequest;
import com.wesleg.devopsproject.core.domain.model.User;
import com.wesleg.devopsproject.core.ports.input.UserCrudInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User")
public class UserController {
    private final UserCrudInputPort userCrudInputPort;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        userCrudInputPort.save(user);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update-password/{username}")
    public ResponseEntity<Void> updateUser(@PathVariable("username") final String username, @RequestBody UserRequest userRequest) {
        userCrudInputPort.updatePassword(username, userRequest.getPassword());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userCrudInputPort.delete(username);
        return ResponseEntity.ok().build();
    }
}
