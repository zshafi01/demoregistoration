package com.example.demoregistoration.controller;

import com.example.demoregistoration.entity.User;
import com.example.demoregistoration.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/admin/add-user")
    @Operation(summary = "save user ", description = "this api will take user as a requestbody and return " +
            "user", tags = "ADMIN APIs")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User addNewUser = userService.saveUser(user);
        return new ResponseEntity<>(addNewUser, HttpStatus.CREATED);
    }
    @GetMapping("/admin/users")
    @Operation(summary = "get all user ", description = "this api will give us list of users " +
            "user", tags = "ADMIN APIs")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/admin/User/{id}/show")
    @Operation(summary = "get user by id", description = "this api will give us user by id " +
            "user", tags = "ADMIN APIs")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
    @GetMapping("/admin/User/{id}/delete")
    @Operation(summary = "delete user ", description = "this api will delete user based on given id" +
            "user", tags = "ADMIN APIs")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try{
         userService.deleteUser(id);
         return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
