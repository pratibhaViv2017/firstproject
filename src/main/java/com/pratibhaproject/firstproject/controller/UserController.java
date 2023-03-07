package com.pratibhaproject.firstproject.controller;

import com.pratibhaproject.firstproject.client.EmployeeFeignClient;
import com.pratibhaproject.firstproject.model.EmployeeResource;
import com.pratibhaproject.firstproject.model.User;
import com.pratibhaproject.firstproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private EmployeeService employeeService;
    private EmployeeFeignClient employeeFeignClient;
    private List<User> users;

    @Autowired
    public UserController(EmployeeService employeeService, EmployeeFeignClient employeeFeignClient) {
        this.employeeService = employeeService;
        this.users = new ArrayList<>();
        this.employeeFeignClient = employeeFeignClient;
    }


    @PostMapping(value = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if(user != null) {
            users.add(user);
            employeeService.samplefun();
        }
        return ResponseEntity.created(URI.create("/user/"+user.getUserId())).body(user);
    }

    @GetMapping(value = "/company_employees", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResource> getEmployees() {
       return ResponseEntity.ok(employeeFeignClient.findAll());
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
