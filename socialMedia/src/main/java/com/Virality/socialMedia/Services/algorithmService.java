package com.Virality.socialMedia.Services;

import org.springframework.stereotype.Service;

@Service
public class algorithmService {
    private Double baseValue=0.10;
    private Integer numberOfLikes=100;
    private Integer numberOfPost=100;
    private Integer numberOfFollowers=100;
    private Integer numberDaysInactive=3;


    //fetch values from DB
    public Double calculation(){
        baseValue=baseValue+(baseValue*((numberOfLikes+numberOfFollowers+numberOfPost)/numberDaysInactive*1.2));

        if(baseValue<0.10)
            return 0.10;
        return baseValue;

    }
}
