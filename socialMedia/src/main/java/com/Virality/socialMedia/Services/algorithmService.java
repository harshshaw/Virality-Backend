package com.Virality.socialMedia.Services;

import org.springframework.stereotype.Service;

@Service
public class algorithmService {
    private Double baseValue=0.10;
    private Integer numberOfLikes=100;
    private Integer numberOfPost=100;
    private Integer numberOfFollowers=100;
    private Double numberDaysInactive=Math.random();



    //fetch values from DB
    public Double calculation(){
        baseValue=baseValue+(baseValue*((numberOfLikes+numberOfFollowers+numberOfPost)/numberDaysInactive*1.2));
        System.out.println(numberDaysInactive);
        //We want to keep baseValue at 0.10 even after long period of inactiveness
        //since this is the minimun it can go for a User
        if(baseValue<0.10)
            return 0.10;
        return baseValue;

    }
}
