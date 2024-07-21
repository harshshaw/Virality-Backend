package com.Virality.Application.Controller;

import com.Virality.Application.Services.algorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class Algorithm {
    @Autowired
    private algorithmService algorithmService;

    @CrossOrigin
    @GetMapping("/algorithm/{userId}")
    public Double algo(@PathVariable("userId") UUID userId)
    {
        return algorithmService.calculation(userId);
    }
}
