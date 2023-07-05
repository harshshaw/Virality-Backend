package com.Virality.socialMedia.Controller;

import com.Virality.socialMedia.Entity.Users;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Post {
    @Autowired
    UserRepo userRepo;
    @PostMapping("/post")
    public void postInfo(@RequestBody Users user){
        Users users=new Users();
        users=user;
        userRepo.save(users);
    }


}
