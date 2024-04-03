package com.ip.VoiceCanvas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class UserDocument {
    
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String bio;
    private int followers;
    private int following;
    private List<String> followersList = new ArrayList<>();
    private List<String> followingList = new ArrayList<>();


    public UserDocument() {
    }

    public UserDocument(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollowers() {
        return this.followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return this.following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public List<String> getFollowersList() {
        return this.followersList;
    }

    public void setFollowersList(List<String> followersList) {
        this.followersList = followersList;
    }

    public List<String> getFollowingList() {
        return this.followingList;
    }

    public void setFollowingList(List<String> followingList) {
        this.followingList = followingList;
    }
    

}
