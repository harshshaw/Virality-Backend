package com.Virality.Application.Services;

import com.Virality.Application.Entity.User;
import com.Virality.Application.Repository.AlgorithmRepo;
import com.Virality.Application.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class algorithmService {

    private Integer numberOfLikes=1000;
    private Integer numberOfPost;
    private Integer numberOfFollowers;
    private Integer numberDaysInactive;
    private Double popularityCardValue;
    @Autowired
    UserRepo userRepo;

    @Autowired
    AlgorithmRepo algorithmRepo;



    //fetch values from DB
    public Double calculation(UUID userID){

        //Fetch data from the repository query
        User response= userRepo.getUserByUserId(userID);
        numberOfPost=response.getPosts().size();
        numberOfFollowers=response.getFollowers().size();
        System.out.println(numberOfFollowers);
        System.out.println(numberOfPost);
        popularityCardValue=response.getPopularityCardValue();

        System.out.println("Query for User Id:"+ userID.toString()+" Card Value:"+ popularityCardValue);

        //BaseValue Calculations based on the provided parameters
        Double newPopularityCardValue;
        System.out.println("Last ActiveDay:"+calculateDaysInactive(userID));
        numberDaysInactive=calculateDaysInactive(userID);
        newPopularityCardValue=popularityCardValue+(0.10*((numberOfLikes+numberOfFollowers+numberOfPost)/(numberDaysInactive*5)));
        response.setPopularityCardValue(newPopularityCardValue);

        //We want to keep baseValue at 0.10 even after long period of inactiveness
        //since this is the minimun it can go for a User
        if(newPopularityCardValue<0.10)
            return 0.10;
        return newPopularityCardValue;

    }

    public Integer calculateDaysInactive(UUID userId){
        UUID userID=userId;
        User response= userRepo.getUserByUserId(userId);
        Date inactiveDay=algorithmRepo.lastPostDate(response);

        Date current=new Date();
        if((inactiveDay.getMonth()-current.getMonth())==0)
            return 1;
        else
            return (inactiveDay.getMonth()-current.getMonth());
    }
}
