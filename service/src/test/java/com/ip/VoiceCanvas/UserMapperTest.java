package com.ip.VoiceCanvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UserMapperTest {
    
    @Test
    void mappingToUserCreatesUserObject(){
        UserDocument mockUserDocument = new UserDocument("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        
        User mockUser = UserMapper.toUser(mockUserDocument);

        assertNotNull(mockUser);
    }

    @Test
    void mappingToUserMapsUsername(){
        UserDocument mockUserDocument = new UserDocument("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        User mockUser = UserMapper.toUser(mockUserDocument);

        assertEquals(mockUserDocument.getUsername(), mockUser.getUsername());

    }

    @Test
    void mappingToUserMapsEmail(){
        UserDocument mockUserDocument = new UserDocument("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        User mockUser = UserMapper.toUser(mockUserDocument);

        assertEquals(mockUserDocument.getEmail(), mockUser.getEmail());

    }

    @Test
    void mappingToUserMapsPassword(){
        UserDocument mockUserDocument = new UserDocument("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        User mockUser = UserMapper.toUser(mockUserDocument);

        assertEquals(mockUserDocument.getPassword(), mockUser.getPassword());

    }

    @Test
    void mappingToUserDocumentCreatesUserDocumentObject(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");

        UserDocument mockUserDocument = UserMapper.toUserDocument(mockUser);

        assertNotNull(mockUserDocument);
    }

    @Test
    void mappingToUserDocumentMapsUsername(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");

        UserDocument mockUserDocument = UserMapper.toUserDocument(mockUser);

        assertNotNull(mockUserDocument.getUsername(), mockUser.getUsername());
    }

    @Test
    void mappingToUserDocumentMapsEmail(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");

        UserDocument mockUserDocument = UserMapper.toUserDocument(mockUser);

        assertNotNull(mockUserDocument.getEmail(), mockUser.getEmail());
    }

    @Test
    void mappingToUserDocumentMapsPassword(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");

        UserDocument mockUserDocument = UserMapper.toUserDocument(mockUser);

        assertNotNull(mockUserDocument.getPassword(), mockUser.getPassword());
    }

    @Test
    void mappingToUserDocumentWithNullThrowsAnException(){
        assertThrows(NullPointerException.class, () -> {
            UserMapper.toUserDocument(null);
        });
    }

    @Test
    void mappingToUserWithNullThrowsAnException(){
        assertThrows(NullPointerException.class, () -> {
            UserMapper.toUser(null);
        });
    }
}
