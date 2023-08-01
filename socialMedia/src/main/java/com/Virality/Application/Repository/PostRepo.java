package com.Virality.Application.Repository;

import com.Virality.Application.Entity.Post;
import com.Virality.Application.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepo extends CrudRepository<Post, UUID> {
    public Post getPostByPostId(UUID postId);

    public void deleteById(UUID postId);
}
