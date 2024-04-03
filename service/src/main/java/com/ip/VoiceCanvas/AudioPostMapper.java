package com.ip.VoiceCanvas;

import java.util.List;
import java.util.stream.Collectors;

public class AudioPostMapper {
    
    public static AudioPost toAudioPost(AudioPostDocument audioPostDocument){
        
        AudioPost audioPost = new AudioPost();
        
        audioPost.setUsername(audioPostDocument.getUsername());
        audioPost.setDate(audioPostDocument.getDate());
        audioPost.setAudioData(audioPostDocument.getAudioData());
         
        return audioPost;
    }

    public static AudioPostDocument toAudioPostDocument(AudioPost audioPost){
        
        AudioPostDocument audioPostDocument = new AudioPostDocument();

        audioPostDocument.setUsername(audioPost.getUsername());
        audioPostDocument.setDate(audioPost.getDate());
        audioPostDocument.setAudioData(audioPost.getAudioData());

        return audioPostDocument;
    }

    public static List<AudioPost> toAudioPosts(List<AudioPostDocument> audioPostDocuments) {
        return audioPostDocuments.stream().map(AudioPostMapper::toAudioPost).collect(Collectors.toList());
    }

}
