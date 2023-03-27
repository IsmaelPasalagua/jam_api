package com.api.chiken.model.services;

import com.api.chiken.model.entities.Comment;
import com.api.chiken.model.entities.User;
import com.api.chiken.model.repositories.CommentRepository;
import com.api.chiken.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
