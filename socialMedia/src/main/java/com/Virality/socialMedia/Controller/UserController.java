package com.Virality.socialMedia.Controller;

import com.Virality.socialMedia.Entity.SocialMedia.User;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/followersCount/{userId}")
    ResponseEntity<Integer> getFollowersCount(@PathVariable("userId") String userId){
        User user=userRepo.getUserByUserId(UUID.fromString(userId));
        return new ResponseEntity<>(user.getFollowers().size(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/followingCount/{userId}")
    ResponseEntity<Integer> getFollowingsCount(@PathVariable("userId") String userId){
        User user=userRepo.getUserByUserId(UUID.fromString(userId));
        return new ResponseEntity<>(user.getFollowings().size(), HttpStatus.ACCEPTED);
    }
}
