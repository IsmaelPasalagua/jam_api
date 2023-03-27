package com.api.chiken.model.services;
import com.api.chiken.model.entities.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.chiken.model.repositories.PostRepository;

import java.util.ArrayList;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ArrayList<Post> getAllPosts() {
        return new ArrayList<>(postRepository.findAll());
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }

    public Post createPost(Post post) {
        // Aquí podrías realizar validaciones y lógica de negocio antes de guardar el post
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        // Verificar si existe el post con el id especificado
        Post existingPost = getPostById(id);
        // Actualizar los campos del post existente con los valores del post recibido como parámetro
        existingPost.setTitle(post.getTitle());
        existingPost.setSlug(post.getSlug());
        existingPost.setSummary(post.getSummary());
        existingPost.setPublished(post.getPublished());
        existingPost.setUser(post.getUser());
        // Guardar el post actualizado
        return postRepository.save(existingPost);
    }

    public void deletePost(Long id) {
        // Verificar si existe el post con el id especificado
        Post existingPost = getPostById(id);
        // Eliminar el post
        postRepository.delete(existingPost);
    }
}

