package com.Virality.socialMedia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Users")
public class Users {
    @Id
    private Long idss;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
