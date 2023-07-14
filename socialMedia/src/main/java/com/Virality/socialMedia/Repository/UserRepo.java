package com.Virality.socialMedia.Repository;

import com.Virality.socialMedia.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<User, UUID> {
public User getUserByUserId(UUID userId);

        @Query("select u from Users u where u.id=?1")
        public Users testQuery(Integer id);

        @Query("select u from Users u   order by u.popularityCardValue desc ")
        public List<Users> leaderBoardQuery();

        @Query("select u.popularityCardValue from Users u where u.id=?1 ")
        public Double currentPopularityCardValue(Integer id);
}
