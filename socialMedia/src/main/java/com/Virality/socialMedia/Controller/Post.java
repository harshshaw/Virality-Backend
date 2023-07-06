//package com.Virality.socialMedia.Controller;
//
//import com.Virality.socialMedia.Entity.User;
//import com.Virality.socialMedia.Repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1")
//public class Post {
//    @Autowired
//    UserRepo userRepo;
//    @PostMapping("/post")
//    public void postInfo(@RequestBody User user){
//        User users=new User();
//        users=user;
//        userRepo.save(users);
//    }
//}
