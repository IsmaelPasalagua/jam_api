package com.api.chiken.model.repositories;

import com.api.chiken.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.chiken.model.entities.Post;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUser(User user);
}
