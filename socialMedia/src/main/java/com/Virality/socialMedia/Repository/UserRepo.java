package com.Virality.socialMedia.Repository;

import com.Virality.socialMedia.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<Users,Long> {
//    public UserDto algorithmParameters(){
//
//    }
}
