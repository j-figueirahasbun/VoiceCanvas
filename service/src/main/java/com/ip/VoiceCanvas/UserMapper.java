package com.ip.VoiceCanvas;

public class UserMapper {
    
    public static UserDocument toUserDocument(User user){
        
        UserDocument userDocument = new UserDocument();
        userDocument.setUsername(user.getUsername());
        userDocument.setEmail(user.getEmail());
        userDocument.setPassword(user.getPassword());
        
        return userDocument;
    }

    public static User toUser(UserDocument userDocument){
        
        User user = new User();
        user.setUsername(userDocument.getUsername());
        user.setEmail(userDocument.getEmail());
        user.setPassword(userDocument.getPassword());
        
        return user;
    }

}
