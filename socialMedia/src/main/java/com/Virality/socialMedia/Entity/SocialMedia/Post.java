package com.Virality.socialMedia.Entity.SocialMedia;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Post")
public class Post {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
