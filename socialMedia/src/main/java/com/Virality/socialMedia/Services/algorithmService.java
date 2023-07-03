package com.Virality.socialMedia.Services;

import com.Virality.socialMedia.Entity.Users;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class algorithmService {
    private Double baseValue=0.10;
    private Integer numberOfLikes=100;
    private Integer numberOfPost;
    private Integer numberOfFollowers;
    private Double numberDaysInactive=Math.random();

    @Autowired
    UserRepo userRepo;


    //fetch values from DB
    public Double calculation(){

        Users response=new Users();
        Integer id=3;
        response=userRepo.testQuery(id);
        numberOfPost=response.getPosts();
        numberOfFollowers=response.getFollowers();
        System.out.println("Query for User Id:"+ id);
        baseValue=baseValue+(baseValue*((numberOfLikes+numberOfFollowers+numberOfPost)/numberDaysInactive*1.2));

        //We want to keep baseValue at 0.10 even after long period of inactiveness
        //since this is the minimun it can go for a User
        if(baseValue<0.10)
            return baseValue;
        return baseValue;

    }
}
