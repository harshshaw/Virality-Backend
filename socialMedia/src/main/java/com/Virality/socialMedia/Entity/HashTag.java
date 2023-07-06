package com.Virality.socialMedia.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID hashTagId;


    public UUID getHashTagId() {
        return hashTagId;
    }

    public void setHashTagId(UUID hashTagId) {
        this.hashTagId = hashTagId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    @ManyToMany(mappedBy = "hashTags")
    private Set<Post> posts;
}
