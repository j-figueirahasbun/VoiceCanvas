package com.ip.VoiceCanvas.DTO;

import java.util.Date;

public class AudioPostCreateDTO {
    
    private String audioData;
    private String username;
    private Date date;

    public String getAudioData() {
        return this.audioData;
    }

    public void setAudioData(String audioData) {
        this.audioData = audioData;
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

}
