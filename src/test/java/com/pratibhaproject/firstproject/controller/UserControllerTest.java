//package com.pratibhaproject.firstproject.controller;
//
//import com.pratibhaproject.firstproject.model.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserControllerTest {
//    private UserController userController;
//
//    @BeforeEach
//    void setUp() {
//        userController = new UserController();
//    }
//
//    @Test
//    void addUser_EmptyUserObjectInRequestAddEmptyObjectToList() {
//        User firstUser = new User();
//        List<User> users = userController.addUser(firstUser);
//        assertEquals(users.size(), 1);
//        assertNull(users.get(0).getUserId());
//    }
//
//    @Test
//    void addUser_WithNullUserRequest_returnsEmptyArrayList() {
//        List<User> users = userController.addUser(null);
//        assertEquals(users.size(), 0);
//    }
//}