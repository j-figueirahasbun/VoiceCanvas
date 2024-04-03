package com.ip.VoiceCanvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserTest {
    
    @Test
    void createUserShouldWork(){

        User Evangeline = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , 
        "woodvale123"); 

        assertNotNull(Evangeline);
    }

    @Test
    void userBioCanBeSet(){

        String username = "User1";
        String password = "password";
        String email = "user@gmail.com";
        String bio = "This is a bio.";

        User mockUser = new User(username, email, password);
        
        mockUser.setBio(bio);

        assertEquals(bio, mockUser.getBio());

    }

}
