package com.Virality.Application.Controller;

import com.Virality.Application.Entity.User;
import com.Virality.Application.Entity.Transaction;
import com.Virality.Application.Repository.UserRepo;
import com.Virality.Application.Services.tradingService;
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
    public List<User> leaderBoard(){
        return userRepo.leaderBoardQuery();
    }

    @PostMapping("/transaction")
    public void transaction(@RequestBody Transaction transaction)
    {
        tradingService.Purchase(transaction);
    }
}
