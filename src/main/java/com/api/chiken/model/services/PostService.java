package com.api.chiken.model.services;
import com.api.chiken.model.entities.Post;
import com.api.chiken.model.entities.User;
import com.api.chiken.model.repositories.UserRepository;
import com.api.chiken.model.requests.PostRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.chiken.model.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;

    public List<Post> index() {
        return postRepository.findAll();
    }

    public Optional<Post> get(Long id) {
        return postRepository.findById(id);
    }

    public Post save(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setSummary(request.getSummary());
        post.setUser(authService.user());
        post.setPublished(new Date(System.currentTimeMillis()));
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> getByUsername(String username) {
        User user = this.userRepository.findByUsername(username).orElseThrow();
        return postRepository.findByUser(user);
    }
}

