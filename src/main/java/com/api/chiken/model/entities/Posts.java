package com.api.chiken.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private String title;
    private String slug;
    private String summary;

    private Date published;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    //Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getSummary() {
        return summary;
    }

    public Date getPublished() {
        return published;
    }

    public User getUser() {
        return user;
    }
//Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
