package com.Virality.Application.Dto;


import com.Virality.Application.Entity.Comment;
import com.Virality.Application.Entity.Reaction;
import java.util.List;
import java.util.Set;

public class PostDto {

    private String userId;
    private byte[] file;

    private String postType;

    private String caption;

    private Set<String> HashTags;

    private Integer likesCount;

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getDislikesCount() {
        return dislikesCount;
    }

    public void setDislikesCount(Integer dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    private Integer dislikesCount;

    public Set<String> getHashTags() {
        return HashTags;
    }

    public void setHashTags(Set<String> hashTags) {
        HashTags = hashTags;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    private String location;

    List<Comment> comments;

    List<Reaction> reactions;

    private Integer commentsCount;
    public void setCommentsCount(Integer commentsCount) {
    }

    public Integer getCommentsCount(){
        return this.commentsCount;
    }

}
