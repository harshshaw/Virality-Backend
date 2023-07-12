package com.Virality.socialMedia.Repository;

import com.Virality.socialMedia.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<User, UUID> {
public User getUserByUserId(UUID userId);
}
