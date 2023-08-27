package com.Virality.Application.Controller;

import com.Virality.Application.Dto.PostDto;
import com.Virality.Application.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/post")
    String createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto).toString();
    }

    @GetMapping("/post/{postId}")
    PostDto getPost(@PathVariable("postId") String postId){
     return postService.getPost(UUID.fromString(postId));
    }

    @DeleteMapping("/post/{postId}")
    void deletePost(@PathVariable("postId") String postId){
        postService.deletePost(UUID.fromString(postId));
    }

    @PostMapping("/postUpdate/{postId}")
    void updatePost(@PathVariable String postId,@RequestBody PostDto updatePost){
        postService.updatePost(UUID.fromString(postId),updatePost);
    }

}
