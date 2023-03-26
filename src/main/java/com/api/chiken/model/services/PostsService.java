package com.api.chiken.model.services;
import com.api.chiken.model.entities.Posts;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.chiken.model.repositories.PostsRepository;

import java.util.ArrayList;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public ArrayList<Posts> getAllPosts() {
        return new ArrayList<>(postsRepository.findAll());
    }

    public Posts getPostById(Long id) {
        return postsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }

    public Posts createPost(Posts post) {
        // Aquí podrías realizar validaciones y lógica de negocio antes de guardar el post
        return postsRepository.save(post);
    }

    public Posts updatePost(Long id, Posts post) {
        // Verificar si existe el post con el id especificado
        Posts existingPost = getPostById(id);
        // Actualizar los campos del post existente con los valores del post recibido como parámetro
        existingPost.setTitle(post.getTitle());
        existingPost.setSlug(post.getSlug());
        existingPost.setSummary(post.getSummary());
        existingPost.setPublished(post.getPublished());
        existingPost.setUser(post.getUser());
        // Guardar el post actualizado
        return postsRepository.save(existingPost);
    }

    public void deletePost(Long id) {
        // Verificar si existe el post con el id especificado
        Posts existingPost = getPostById(id);
        // Eliminar el post
        postsRepository.delete(existingPost);
    }
}

