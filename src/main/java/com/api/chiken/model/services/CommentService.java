package com.api.chiken.model.services;

import com.api.chiken.model.entities.Comment;
import com.api.chiken.model.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllPostComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getPostCommentsById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment savePostComments(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deletePostCommentsById(Long id) {
        commentRepository.deleteById(id);
    }
}