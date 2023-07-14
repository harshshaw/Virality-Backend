package com.Virality.socialMedia.Services;

import com.Virality.socialMedia.Entity.User;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class algorithmService {

    private Integer numberOfLikes=1000;
    private Integer numberOfPost;
    private Integer numberOfFollowers;
    private Double numberDaysInactive=10.00;
    private Double popularityCardValue;
    private User response;




    @Autowired
    UserRepo userRepo;


    //fetch values from DB
    public Double calculation(UUID userID){

        //Fetch data from the repository query
        User user= userRepo.getUserByUserId(userID);
        numberOfPost=user.getPosts().size();
        numberOfFollowers=response.getFollowers().size();
        popularityCardValue=response.getPopularityCardValue();

        System.out.println("Query for User Id:"+ userID.toString()+" Card Value:"+ popularityCardValue);

        //BaseValue Calculations based on the provided parameters
        Double newPopularityCardValue;
        newPopularityCardValue=popularityCardValue+(0.10*((numberOfLikes+numberOfFollowers+numberOfPost)/(numberDaysInactive*5)));
        response.setPopularityCardValue(newPopularityCardValue);

        //We want to keep baseValue at 0.10 even after long period of inactiveness
        //since this is the minimun it can go for a User
        if(newPopularityCardValue<0.10)
            return 0.10;
        return newPopularityCardValue;

    }
}
