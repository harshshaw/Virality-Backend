package com.Virality.socialMedia.Services;

import com.Virality.socialMedia.Entity.Users;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class algorithmService {

    private Integer numberOfLikes=1000;
    private Integer numberOfPost;
    private Integer numberOfFollowers;
    private Double numberDaysInactive=10.00;
    private Double popularityCardValue;
    private Users response;

    private Integer id=1;



    @Autowired
    UserRepo userRepo;


    //fetch values from DB
    public Double calculation(Integer id){

        //Fetch data from the repository query
        response=userRepo.testQuery(id);
        numberOfPost=response.getPosts();
        numberOfFollowers=response.getFollowers();
        popularityCardValue=response.getPopularityCardValue();

        System.out.println("Query for User Id:"+ id+" Card Value:"+ popularityCardValue);

        //BaseValue Calculations based on the provided parameters
        Double newPopularityCardValue;
        newPopularityCardValue=popularityCardValue+(0.10*((numberOfLikes+numberOfFollowers+numberOfPost)/(numberDaysInactive*5)));
        response.setPopularityCardValue(newPopularityCardValue);

        //We want to keep baseValue at 0.10 even after long period of inactiveness
        //since this is the minimum it can go for a User
        if(newPopularityCardValue<0.10)
            return 0.10;
        return newPopularityCardValue;

    }
}
