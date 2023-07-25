package com.Virality.Application.Repository;

import com.Virality.Application.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<User, UUID> {
public User getUserByUserId(UUID userId);

        @Query("select u from Users u where u.id=?1")
        public User testQuery(UUID id);

        @Query("select u from Users u   order by u.popularityCardValue desc ")
        public List<User> leaderBoardQuery();

        @Query("select u.popularityCardValue from Users u where u.id=?1 ")
        public Double currentPopularityCardValue(UUID id);
}
