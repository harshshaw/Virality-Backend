package com.Virality.Application.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Entity(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(unique = true)
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @ManyToMany
    @JoinTable(
            name = "user_followers",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private List<User> followers;

    @ManyToMany
    @JoinTable(
            name = "user_followings",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private List<User> followings;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    private Double popularityCardValue;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> commentsGiven;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reaction> reactionsGiven;


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Double getPopularityCardValue() {
        return popularityCardValue;
    }

    public void setPopularityCardValue(Double popularityCardValue) {
        this.popularityCardValue = popularityCardValue;
    }

    public void addFollower(User user){
        if(Objects.isNull(this.followers)){
            this.followers=new ArrayList<>();
        }
        this.followers.add(user);
    }

    public void addFollowing(User user){
        if(Objects.isNull(this.followings)){
            this.followings=new ArrayList<>();
        }
        this.followings.add(user);
    }


    public void addPost(Post post){
        if(Objects.isNull(this.posts)){
            this.posts=new ArrayList<>();
        }
        this.posts.add(post);
    }

    public void addReactionsGiven(Reaction reaction){
        if(Objects.isNull(this.reactionsGiven)){
            this.reactionsGiven=new ArrayList<>();
        }
        this.reactionsGiven.add(reaction);
    }

    public void addCommentsGiven(Comment comment){
        if(Objects.isNull(this.commentsGiven)){
            this.commentsGiven=new ArrayList<>();
        }
        this.commentsGiven.add(comment);
    }

}
