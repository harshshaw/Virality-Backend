package com.Virality.socialMedia.Repository;

import com.Virality.socialMedia.Entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<Users,Long> {
        @Query("select u from Users u where u.id=?1")
        public Users testQuery(Integer id);
}
