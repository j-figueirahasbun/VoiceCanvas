package com.ip.VoiceCanvas;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "audios")
public class AudioPostDocument {
    
    @Id
    private String id;
    private String username;
    private Date date;
    private String audioData;


    public AudioPostDocument() {
    }

    public AudioPostDocument(String username, Date date, String audioData) {
        this.username = username;
        this.date = date;
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

    public String getAudioData() {
        return this.audioData;
    }

    public void setAudioData(String audioData) {
        this.audioData = audioData;
    }

}
