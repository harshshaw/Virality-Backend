package com.Virality.socialMedia.Controller;

import com.Virality.socialMedia.Services.algorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Algorithm {
    @Autowired
    private algorithmService algorithmService;

    @GetMapping("/algorithm")
    @ResponseBody
    public Double algo(@RequestParam Integer id)
    {
        return algorithmService.calculation(id);
    }
}
