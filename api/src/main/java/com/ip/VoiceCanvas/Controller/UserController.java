package com.ip.VoiceCanvas.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.ip.VoiceCanvas.User;
import com.ip.VoiceCanvas.UserSearchDTO;
import com.ip.VoiceCanvas.UserService;
import com.ip.VoiceCanvas.DTO.UserLoginDTO;
import com.ip.VoiceCanvas.DTO.UserSignUpDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody UserSignUpDTO userSignUpDTO){
        User user = new User();
        user.setUsername(userSignUpDTO.getUsername());
        user.setEmail(userSignUpDTO.getEmail());
        user.setPassword(userSignUpDTO.getPassword());

        userService.createUser(user);

        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        boolean isAuthenticated = userService.authenticateUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        
        if (isAuthenticated) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or Password", HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/search/{username}")
    public ResponseEntity<List<UserSearchDTO>> searchUsername(@PathVariable String username) {  
        List<UserSearchDTO> searchResult = userService.findUsersByUsername(username);
        return ResponseEntity.ok(searchResult);
    }

    @PutMapping("follow/{username}/{localusername}")
    public ResponseEntity<?> followUser(@PathVariable String username, @PathVariable String localusername) {
        try {userService.followUser(localusername, username);
            return ResponseEntity.ok("Followed User: " + username + " by " + localusername);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error following user: " + e.getMessage());
            }
    }

    @PutMapping("unfollow/{username}/{localusername}")
    public ResponseEntity<?> unfollowUser(@PathVariable String username, @PathVariable String localusername) {
        try {userService.unfollowUser(localusername, username);
            return ResponseEntity.ok("Followed User: " + username + " by " + localusername);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error unfollowing user: " + e.getMessage());
        }
    
    }

}
