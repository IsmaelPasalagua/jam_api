package com.api.chiken.model.services;

import com.api.chiken.model.entities.PostComments;
import com.api.chiken.model.repositories.PostCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostCommentsService {

    @Autowired
    private PostCommentsRepository postCommentsRepository;

    public List<PostComments> getAllPostComments() {
        return postCommentsRepository.findAll();
    }

    public Optional<PostComments> getPostCommentsById(Long id) {
        return postCommentsRepository.findById(id);
    }

    public PostComments savePostComments(PostComments postComments) {
        return postCommentsRepository.save(postComments);
    }

    public void deletePostCommentsById(Long id) {
        postCommentsRepository.deleteById(id);
    }
}