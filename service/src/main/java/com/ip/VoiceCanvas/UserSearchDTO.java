package com.ip.VoiceCanvas;


public class UserSearchDTO {
    private String username;
    private int followers;
    private int following;
    private String bio;

    public UserSearchDTO() {
    
    }

    public UserSearchDTO(String username, int followers, int following, String bio) {
        this.username = username;
        this.followers = followers;
        this.following = following;
        this.bio = bio;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}



