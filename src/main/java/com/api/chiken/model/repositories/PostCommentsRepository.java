package com.api.chiken.model.repositories;

import com.api.chiken.model.entities.PostComments;
import com.api.chiken.model.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface PostCommentsRepository extends JpaRepository<PostComments, Long> {
    Optional<PostComments> findByPosts(Posts posts);

    Optional<PostComments> findByPostsAndPublishedBetween(Posts posts, Date startDate, Date endDate);

    Long countByPosts(Posts posts);
}
