package com.api.chiken.controllers;

import com.api.chiken.model.entities.Comment;
import com.api.chiken.model.entities.Post;
import com.api.chiken.model.requests.CommentRequest;
import com.api.chiken.model.requests.PostRequest;
import com.api.chiken.model.services.CommentService;
import com.api.chiken.model.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

   @GetMapping
    public ResponseEntity<List<Post>> index(){
       return ResponseEntity.ok().body(this.postService.index());
   }

   @PostMapping
   public ResponseEntity<Post> save(@RequestBody PostRequest request){
       return ResponseEntity.ok().body(this.postService.save(request));
   }

    @PostMapping("/{id}")
    public ResponseEntity<Comment> saveComment(@PathVariable("id") Long id, @RequestBody CommentRequest request){
        return ResponseEntity.ok().body(this.commentService.save(id, request));
    }

   @GetMapping("/{id}")
   public ResponseEntity<Optional<Post>> getById(@PathVariable("id") Long id){
       return ResponseEntity.ok().body(this.postService.get(id));
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        this.postService.delete(id);
        return ResponseEntity.ok().body("Listo");
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Post>> getById(@PathVariable("username") String username){
        return ResponseEntity.ok().body(this.postService.getByUsername(username));
    }
}
