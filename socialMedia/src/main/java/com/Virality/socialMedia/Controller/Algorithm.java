package com.Virality.socialMedia.Controller;

import com.Virality.socialMedia.Services.algorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class Algorithm {
    @Autowired
    private algorithmService algorithmService;

    @GetMapping("/algorithm/{userId}")
    public Double algo(@PathVariable("userId") UUID userId)
    {
        return algorithmService.calculation(userId);
    }
}
