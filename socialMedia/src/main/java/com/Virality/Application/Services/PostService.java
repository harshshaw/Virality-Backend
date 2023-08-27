package com.Virality.Application.Services;

import com.Virality.Application.Dto.PostDto;
import com.Virality.Application.Entity.HashTag;
import com.Virality.Application.Entity.Post;
import com.Virality.Application.Entity.PostType;
import com.Virality.Application.Entity.User;
import com.Virality.Application.Repository.HashTagRepo;
import com.Virality.Application.Repository.PostRepo;
import com.Virality.Application.Repository.UserRepo;
import com.Virality.Application.Utility.LocalStorageService;
import com.Virality.Application.Utility.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;
//    @Autowired
//    HashTagRepo hashTagRepo;
//
    @Autowired
    LocalStorageService storageService;

    public UUID createPost(PostDto postDto){

        User user=userRepo.getUserByUserId(UUID.fromString(postDto.getUserId()));

        Post post=new Post();
        post.setPostType(PostType.valueOf(postDto.getPostType()));
        post.setCaption(postDto.getCaption());
        post.setLocation(postDto.getLocation());
        post.setUser(user);
        post.setFileUrl(storageService.save(postDto.getFile()));

        user.addPost(post);

        postRepo.save(post);

        return post.getPostId();
    }

    public PostDto getPost(UUID postId){

        Post post=postRepo.getPostByPostId(postId);
        String postFilePath=post.getFileUrl();
        PostDto postDto=new PostDto();

        postDto.setFile(storageService.get(postFilePath));
        postDto.setComments(post.getComments());
        postDto.setCaption(post.getCaption());
        postDto.setReactions(post.getReactions());
        postDto.setPostType(post.getPostType().toString());
        postDto.setLocation(post.getLocation());
        postDto.setUserId(post.getUser().getUserId().toString());
        postDto.setLikesCount(post.getLikesCount());
        postDto.setDislikesCount(post.getDislikesCount());
        postDto.setCommentsCount(post.getCommentsCount());
        return postDto;
    }

    public void deletePost(UUID postId){
        Post post=postRepo.getPostByPostId(postId);
        String postFilePath=post.getFileUrl();
        postRepo.deleteById(postId);
        storageService.delete(postFilePath);
    }



//    public void associateHashTagAndPost(Post post, Set<String> hashTags){
//        List<HashTag> allHashTags=hashTagRepo.findAll();
//        hashTags.forEach(currentHashTag->{
//            Optional<HashTag> tagOptional=allHashTags.stream().filter(hashTag -> hashTag.getHashTag().equals(currentHashTag)).findFirst();
//            HashTag tempHashTag;
//            if(tagOptional.isPresent()){
//                tempHashTag=tagOptional.get();
//            }
//            else{
//                HashTag newHashTag=new HashTag();
//                allHashTags.add(newHashTag);
//                tempHashTag=newHashTag;
//            }
//
//            allHashTags.add(tempHashTag);
//        });
//    }


}
