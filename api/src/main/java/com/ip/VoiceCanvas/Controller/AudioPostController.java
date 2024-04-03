package com.ip.VoiceCanvas.Controller;

import com.ip.VoiceCanvas.AudioPost;
import com.ip.VoiceCanvas.AudioPostService;
import com.ip.VoiceCanvas.DTO.AudioPostCreateDTO;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/audio")
public class AudioPostController {

    private final AudioPostService audioPostService;

    public AudioPostController(AudioPostService audioPostService) {
        this.audioPostService = audioPostService;
    };

    @PostMapping("/create")
    public ResponseEntity<String> createAudio(@RequestBody AudioPostCreateDTO audioPostCreateDTO){
        AudioPost audioPost = new AudioPost();
        audioPost.setUsername(audioPostCreateDTO.getUsername());
        audioPost.setDate(audioPostCreateDTO.getDate());
        audioPost.setAudioData(audioPostCreateDTO.getAudioData());

        audioPostService.createAudioPost(audioPost);

        return new ResponseEntity<>("AudioPost created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAudiosByUsername/{username}")
    public ResponseEntity<List<AudioPost>> getAudiosByUsername(@PathVariable String username) {
        List<AudioPost> audioPosts = audioPostService.findAudiosByUsername(username);
        return ResponseEntity.ok(audioPosts);
    }

    @GetMapping("/getAudiosOfFollowedUsers/{username}")
    public ResponseEntity<List<AudioPost>> getAudiosOfFollowedUsers(@PathVariable String username) {
        List<AudioPost> audioPosts = audioPostService.findAudiosOfFollowedUsers(username);
        return ResponseEntity.ok(audioPosts);
    }
    
}