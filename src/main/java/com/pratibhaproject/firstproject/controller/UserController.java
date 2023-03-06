package com.pratibhaproject.firstproject.controller;

import com.pratibhaproject.firstproject.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>();

    @PostMapping(value = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if(user != null) {
            users.add(user);
        }
        return ResponseEntity.created(URI.create("/user/"+user.getUserId())).body(user);
    }

    @GetMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
       return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User returnedUser = users.stream()
                .filter(user -> Objects.equals(user.getUserId(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found in list"));
        return ResponseEntity.ok(returnedUser);
    }

}
