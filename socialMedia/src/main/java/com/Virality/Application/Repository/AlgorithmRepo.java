package com.Virality.Application.Repository;

import com.Virality.Application.Entity.Post;
import com.Virality.Application.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;
@Repository
public interface AlgorithmRepo extends CrudRepository<Post,Long> {
    @Query("select p.updatedDate from Post p where p.user=?1")
    public Date lastPostDate(User userId);
}
