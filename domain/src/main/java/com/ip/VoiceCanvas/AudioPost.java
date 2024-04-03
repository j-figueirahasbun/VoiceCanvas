package com.ip.VoiceCanvas;

import java.util.Date;

public class AudioPost {
        
    private String username;
    private Date date;
    private String audioData;

    public AudioPost(String username, Date date, String audioData) {
        this.username = username;
        this.date = new Date();
        this.audioData = audioData;
    }

    public AudioPost() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAudioData() {
        return this.audioData;
    }

    public void setAudioData(String audioData) {
        this.audioData = audioData;
    }

}
