package com.Virality.socialMedia.Controller;

import com.Virality.socialMedia.Entity.SocialMedia.Users;
import com.Virality.socialMedia.Entity.Trading.Transaction;
import com.Virality.socialMedia.Repository.UserRepo;
import com.Virality.socialMedia.Services.Trading.tradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Trading {
    @Autowired
    UserRepo userRepo;
    @Autowired
    tradingService tradingService;
    @GetMapping("/leaderboard")
    public List<Users> leaderBoard(){
        return userRepo.leaderBoardQuery();
    }

    @PostMapping("/transaction")
    public void transaction(@RequestBody Transaction transaction)
    {
        tradingService.Purchase(transaction);
    }
}
