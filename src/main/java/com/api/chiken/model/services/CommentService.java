package com.api.chiken.model.services;

import com.api.chiken.model.entities.Comment;
import com.api.chiken.model.entities.Post;
import com.api.chiken.model.entities.User;
import com.api.chiken.model.repositories.CommentRepository;
import com.api.chiken.model.repositories.UserRepository;
import com.api.chiken.model.requests.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;

    public List<Comment> index() {
        return commentRepository.findAll();
    }

    public Optional<Comment> get(Long id) {
        return commentRepository.findById(id);
    }

    public Comment save(Long id, CommentRequest request) {
        Post post = this.postService.get(id).orElseThrow();
        Comment comment = new Comment();
        User user = this.authService.user();
        List<Comment> currentCommentsUser = user.getComments();
        List<Comment> currentCommentsPost = post.getComments();
        comment.setTitle(request.getTitle());
        comment.setContent(request.getContent());
        comment.setUser(user);
        comment.setPublished(new Date(System.currentTimeMillis()));
        comment.setPost(post);
        currentCommentsPost.add(comment);
        currentCommentsUser.add(comment);
        post.setComments(currentCommentsPost);
        user.setComments(currentCommentsUser);
        return commentRepository.saveAndFlush(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}