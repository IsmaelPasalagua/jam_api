package com.api.chiken.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post_comments")
public class PostComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private String title;
    private Date published;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts posts;


    //Getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublished() {
        return published;
    }

    public User getUser() {
        return user;
    }

    public Posts getPosts() {
        return posts;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
}
