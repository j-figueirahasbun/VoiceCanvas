package com.ip.VoiceCanvas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioPostService {
    
    private final AudioPostRepository audioPostRepository;
    private final UserService userService;

    @Autowired
    public AudioPostService(AudioPostRepository audioPostRepository, UserService userService) {
        this.audioPostRepository = audioPostRepository;
        this.userService = userService;
    }

    @SuppressWarnings("null")
    public AudioPost createAudioPost(AudioPost audioPost){
        AudioPostDocument audioPostDocument = AudioPostMapper.toAudioPostDocument(audioPost);
        AudioPostDocument savedAudioDocument = audioPostRepository.save(audioPostDocument);

        return AudioPostMapper.toAudioPost(savedAudioDocument);
    }

    public List<AudioPost> findAudiosByUsername(String username) {
        List<AudioPostDocument> audioPostDocuments = audioPostRepository.findByUsername(username);
        
        return AudioPostMapper.toAudioPosts(audioPostDocuments);
    
    }
    

    public List<AudioPost> findAudiosOfFollowedUsers(String username) {
        List<String> followedUsers = userService.getFollowedUsers(username);
        List<AudioPost> audioPosts = new ArrayList<>();

        for (String followedUser : followedUsers) {
            List<AudioPostDocument> audioPostDocuments = audioPostRepository.findByUsername(followedUser);
            audioPosts.addAll(AudioPostMapper.toAudioPosts(audioPostDocuments));
        }

        return audioPosts;   
    }

}
