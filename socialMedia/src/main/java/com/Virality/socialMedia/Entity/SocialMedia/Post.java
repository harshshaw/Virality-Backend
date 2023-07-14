package com.Virality.socialMedia.Entity.SocialMedia;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Entity(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    private String caption;

    private String location;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<Reaction> reactions;
    @CreationTimestamp
    private Date createdDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_hashtag",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "hashTagId"))
    private Set<HashTag> hashTags;

    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<HashTag> getHashTags() {
        return hashTags;
    }

    public void setHashTags(Set<HashTag> hashTags) {
        this.hashTags = hashTags;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @UpdateTimestamp
    private Date updatedDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
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

    public void addReaction(Reaction reaction){
        if(Objects.isNull(this.reactions)){
            this.reactions=new ArrayList<>();
        }
        this.reactions.add(reaction);
    }

    public void addComment(Comment comment){
        if(Objects.isNull(this.comments)){
            this.comments=new ArrayList<>();
        }
        this.comments.add(comment);
    }


}
