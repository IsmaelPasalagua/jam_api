package com.api.chiken.model.services;
import com.api.chiken.model.entities.Post;
import com.api.chiken.model.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.chiken.model.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> index() {
        return postRepository.findAll();
    }

    public Optional<Post> get(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> getByUser(User user) {
        return postRepository.findByUser(user);
    }
}

