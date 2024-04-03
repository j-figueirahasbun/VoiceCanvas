package com.ip.VoiceCanvas;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @SuppressWarnings("null")
    public User createUser(User user){
        UserDocument userDocument = UserMapper.toUserDocument(user);
        UserDocument savedUserDocument = userRepository.save(userDocument);

        return UserMapper.toUser(savedUserDocument);
    }


    public boolean authenticateUser(String username, String password){
        Optional<UserDocument> optionalUserDocument = userRepository.findByUsername(username);

        if (optionalUserDocument.isPresent()) {
            UserDocument userDocument = optionalUserDocument.get();
            User user = UserMapper.toUser(userDocument);

            if (user.getPassword().equals(password)) {
                
                return true;
            } else {
                
                return false;
            }
        } else {
            
            return false;
        }
    }


    public List<UserSearchDTO> findUsersByUsername(String username) {
        Optional<UserDocument> users = userRepository.findByUsername(username);
        
        return users.stream()
                    .map(user -> new UserSearchDTO(user.getUsername(), user.getFollowers(), user.getFollowing(), user.getBio()))
                    .collect(Collectors.toList());    
    }


    public void followUser(String localUsername, String targetUsername) {
        Optional<UserDocument> optionalLocalUser = userRepository.findByUsername(localUsername);
        Optional<UserDocument> optionalTargetUser = userRepository.findByUsername(targetUsername);

        if (optionalLocalUser.isPresent() && optionalTargetUser.isPresent()) {
            UserDocument localUser = optionalLocalUser.get();
            UserDocument targetUser = optionalTargetUser.get();

            if (targetUser.getFollowersList() == null) {
                targetUser.setFollowersList(new ArrayList<>());
            }

            targetUser.getFollowersList().add(localUsername);
            targetUser.setFollowers(targetUser.getFollowers() + 1);
            
            if (localUser.getFollowingList() == null) {
                localUser.setFollowingList(new ArrayList<>());
            }

            localUser.getFollowingList().add(targetUsername);
            localUser.setFollowing(localUser.getFollowing() + 1);
            
            userRepository.save(targetUser);
            userRepository.save(localUser);

        } else {
            
            throw new IllegalArgumentException("User not found.");
        }
    }


    public void unfollowUser(String localUsername, String targetUsername) {
        Optional<UserDocument> optionalLocalUser = userRepository.findByUsername(localUsername);
        Optional<UserDocument> optionalTargetUser = userRepository.findByUsername(targetUsername);

        if (optionalLocalUser.isPresent() && optionalTargetUser.isPresent()) {
            UserDocument localUser = optionalLocalUser.get();
            UserDocument targetUser = optionalTargetUser.get();

            targetUser.getFollowersList().remove(localUsername);             
            targetUser.setFollowers(targetUser.getFollowers() -1);

            localUser.getFollowingList().remove(targetUsername);
            localUser.setFollowing(localUser.getFollowing() - 1);

            userRepository.save(targetUser);
            userRepository.save(localUser);

        } else {
            
            throw new IllegalArgumentException("User not found.");
        }
    }

    public List<String> getFollowedUsers(String username) {
        Optional<UserDocument> optionalUserDocument = userRepository.findByUsername(username);
        
        if (optionalUserDocument.isPresent()) {
            UserDocument userDocument = optionalUserDocument.get();
            
            return userDocument.getFollowingList();
        
        } else {
            
            throw new IllegalArgumentException("User not found.");
        }
    }

}
