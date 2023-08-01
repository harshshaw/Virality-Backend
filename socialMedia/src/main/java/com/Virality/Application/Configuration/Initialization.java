package com.Virality.Application.Configuration;

import com.Virality.Application.Entity.*;
import com.Virality.Application.Repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initialization{
    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    void init(){
        //log.info("Seeding started");

        //
        User user1=new User();
        user1.setUserName("hrithikroshan");
        user1.setAge(40);
        user1.setGender(Gender.Male);
        user1.setPopularityCardValue(100.0);

        User user2=new User();
        user2.setUserName("melrobbins");
        user2.setAge(62);
        user2.setGender(Gender.Female);
        user2.setPopularityCardValue(90.0);

        User user3=new User();
        user3.setUserName("davidgoggins");
        user3.setAge(43);
        user3.setGender(Gender.Male);
        user3.setPopularityCardValue(102.0);

        User user4=new User();
        user4.setUserName("danfounder");
        user4.setAge(45);
        user4.setGender(Gender.Male);
        user4.setPopularityCardValue(118.0);

        User user5=new User();
        user5.setUserName("timbiohacker");
        user5.setAge(31);
        user5.setGender(Gender.Male);
        user5.setPopularityCardValue(68.0);

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
        userRepo.save(user5);


        //Following
        //1:[2,3,4]
        //2:[1,3,4]
        //3:[4,5]
        //4:[2,5]
        //5:[1,4]

        //Follower
        //1:[2,5]
        //2:[1,4]
        //3:[1,2]
        //4:[1,2,3,5]
        //5:[3,4]

        user1.addFollowing(user2);
        user2.addFollowing(user1);

        user1.addFollowing(user3);
        user3.addFollower(user1);

        user1.addFollowing(user4);
        user4.addFollower(user1);

        user2.addFollowing(user1);
        user1.addFollower(user2);

        user2.addFollowing(user3);
        user3.addFollower(user2);

        user2.addFollowing(user4);
        user4.addFollower(user2);

        user3.addFollowing(user5);
        user5.addFollower(user3);

        user3.addFollowing(user4);
        user4.addFollower(user3);

        user4.addFollowing(user2);
        user2.addFollower(user4);

        user4.addFollowing(user5);
        user5.addFollower(user4);

        user5.addFollowing(user1);
        user1.addFollower(user1);

        user5.addFollowing(user4);
        user4.addFollower(user5);

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
        userRepo.save(user5);



        //post creation
        //user1:[post1]
        //user2:[post2]
        Post post1=new Post();
        post1.setCaption("Happy birthday Dr. Darshan. Keep filling our lives with the best of health hacks . May all our NEXT years be full of HEALTH! Stay amazing");
        post1.setLocation("Mumbai");
        post1.setPostType(PostType.PICTURE);
        post1.setUser(user1);

        Post post2=new Post();
        post2.setCaption("Experience the power of innovation with the #ASUS Zenbook S 13 OLED, delivering uncompromising performance in a compact, slim & lightweight design. Truly #Thincredible");
        post2.setLocation("Agra");
        post2.setPostType(PostType.REEL);
        post2.setUser(user2);
        user1.addPost(post1);
        user2.addPost(post2);




        //Reactions on post1
        //post1 liked by user1, disliked by user3

        Reaction reaction2=new Reaction();
        reaction2.setPost(post1);
        reaction2.setSourceType(SourceType.POST);
        reaction2.setUser(user3);
        reaction2.setReactionType(ReactionType.DISLIKE);


        Reaction reaction1=new Reaction();
        reaction1.setPost(post1);
        reaction1.setSourceType(SourceType.POST);
        reaction1.setUser(user1);
        reaction1.setReactionType(ReactionType.LIKE);


        post1.addReaction(reaction2);
        post1.addReaction(reaction1);



        //Reactions on post2
        //post2 liked by user4 and user5
        Reaction reaction3=new Reaction();
        reaction3.setPost(post2);
        reaction3.setSourceType(SourceType.POST);
        reaction3.setUser(user4);
        reaction3.setReactionType(ReactionType.LIKE);

        Reaction reaction4=new Reaction();
        reaction4.setPost(post2);
        reaction4.setSourceType(SourceType.POST);
        reaction4.setUser(user5);
        reaction4.setReactionType(ReactionType.LIKE);

        post2.addReaction(reaction3);
        post2.addReaction(reaction4);

        //Comments on post1
        //user4 commented on post1
        Comment comment1=new Comment();
        comment1.setPost(post1);
        comment1.setUser(user4);
        comment1.setSourceType(SourceType.POST);
        comment1.setCommentContent("Happy Birthday");

        post1.addComment(comment1);

        //Comments on post2
        //user2 and user3 commented on post2
        Comment comment2=new Comment();
        comment2.setPost(post2);
        comment2.setUser(user2);
        comment2.setSourceType(SourceType.POST);
        comment2.setCommentContent("You gained a follower");


        Comment comment3=new Comment();
        comment3.setPost(post2);
        comment3.setUser(user3);
        comment3.setSourceType(SourceType.POST);
        comment3.setCommentContent("Amazing content");


        post2.addComment(comment2);
        post2.addComment(comment3);

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
        userRepo.save(user5);


    }
}
