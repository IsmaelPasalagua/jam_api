package com.api.chiken.controllers;


import com.api.chiken.model.entities.Post;
import com.api.chiken.model.entities.User;
import com.api.chiken.model.services.PostService;
import com.api.chiken.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getById(@PathVariable("username") String username){
        return ResponseEntity.ok().body(this.userService.getByUsername(username));
    }
}
