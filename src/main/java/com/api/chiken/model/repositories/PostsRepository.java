package com.api.chiken.model.repositories;

import com.api.chiken.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.chiken.model.entities.Posts;
import java.util.Optional;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findByUser(User user);
}
