package com.Virality.socialMedia.Entity.SocialMedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Users")
public class Users {
    @Id
    private Integer id;
    private String userName;
    private Integer age;
    @JsonProperty("Gender")
    private String gender;
    private Integer followers;
    private String userProfilePic;
    private Integer following;
    private Integer posts;
    private Double popularityCardValue;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Integer getPosts() {
        return posts;
    }

    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    public Double getPopularityCardValue() {
        return popularityCardValue;
    }

    public void setPopularityCardValue(Double popularityCardValue) {
        this.popularityCardValue = popularityCardValue;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }
}
