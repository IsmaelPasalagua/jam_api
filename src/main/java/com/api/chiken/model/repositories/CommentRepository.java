package com.api.chiken.model.repositories;

import com.api.chiken.model.entities.Comment;
import com.api.chiken.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByPost(Post post);

    Optional<Comment> findByPostAndPublishedBetween(Post post, Date startDate, Date endDate);

    Long countByPost(Post post);
}
