package com.Virality.socialMedia.Controller;

import com.Virality.socialMedia.Entity.SocialMedia.Users;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Trading {
    @Autowired
    UserRepo userRepo;
    @GetMapping("/leaderboard")
    public List<Users> leaderBoard(){
        return userRepo.leaderBoardQuery();
    }
}
