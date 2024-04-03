package com.ip.VoiceCanvas;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;


public interface UserRepository extends MongoRepository<UserDocument, String> {
    
    Optional<UserDocument> findByUsername(String username);

    Optional<UserDocument> findByEmail(String email);

    Optional<UserDocument> findByUsernameAndPassword(String username, String password);
}
