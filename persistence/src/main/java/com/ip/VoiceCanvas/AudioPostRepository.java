package com.ip.VoiceCanvas;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface AudioPostRepository extends MongoRepository<AudioPostDocument, String> {
    
    List<AudioPostDocument> findByUsername(String username);

    List<AudioPostDocument> findByDate(Date date);

}
