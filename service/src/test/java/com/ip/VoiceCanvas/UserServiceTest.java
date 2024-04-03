package com.ip.VoiceCanvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class UserServiceTest {
    
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @SuppressWarnings("null")
    @Test
    void testCreateUserNotNull(){

        String username = "UserTest1";
        String email = "user1@gmail.com";
        String password = "password";

        User mockUser = new User(username, email, password);

        //MockBehavior
        UserDocument expectedUserDocument = new UserDocument(username, email, password);
        when(userRepository.save(any(UserDocument.class))).thenReturn(expectedUserDocument);

        //actual method

        User createUserResults = userService.createUser(mockUser);

        assertNotNull(createUserResults);
    }

    @SuppressWarnings("null")
    @Test
    void testCreateUserHasCorrectUsername(){

        String username = "UserTest1";
        String email = "user1@gmail.com";
        String password = "password";

        User mockUser = new User(username, email, password);

        //MockBehavior
        UserDocument expectedUserDocument = new UserDocument(username, email, password);
        when(userRepository.save(any(UserDocument.class))).thenReturn(expectedUserDocument);

        //actual method

        User createUserResults = userService.createUser(mockUser);

        assertEquals(createUserResults.getUsername(), mockUser.getUsername());
    }

    @SuppressWarnings("null")
    @Test
    void testCreateUserHasCorrectPassword(){

        String username = "UserTest1";
        String email = "user1@gmail.com";
        String password = "password";

        User mockUser = new User(username, email, password);

        //MockBehavior
        UserDocument expectedUserDocument = new UserDocument(username, email, password);
        when(userRepository.save(any(UserDocument.class))).thenReturn(expectedUserDocument);

        //actual method

        User createUserResults = userService.createUser(mockUser);

        assertNotNull(createUserResults.getPassword(), mockUser.getPassword());
    }

    @SuppressWarnings("null")
    @Test
    void testCreateUserHasCorrectEmail(){

        String username = "UserTest1";
        String email = "user1@gmail.com";
        String password = "password";

        User mockUser = new User(username, email, password);

        //MockBehavior
        UserDocument expectedUserDocument = new UserDocument(username, email, password);
        when(userRepository.save(any(UserDocument.class))).thenReturn(expectedUserDocument);

        //actual method

        User createUserResults = userService.createUser(mockUser);

        assertNotNull(createUserResults.getEmail(), mockUser.getEmail());
    }

    @Test
    void authenticateUserWithValidCredentialsReturnsTrue(){

        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);

        //Mock behavior
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        boolean isAuthenticated = userService.authenticateUser(username, password);

        //Assert
        assertTrue(isAuthenticated);
    }

    @Test
    void authenticateUserWithWrongCredentialsReturnsFalse(){

        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);

        //Mock behavior
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        boolean isAuthenticated = userService.authenticateUser(username, "WrongPassword");

        //Assert
        assertFalse(isAuthenticated);
    }

    @Test
    void authenticateUserWithWrongUsernameReturnsFalse(){
        String username = "UserTest1";
        String password = "password";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        boolean isAuthenticated = userService.authenticateUser(username, password);

        assertFalse(isAuthenticated);
    }

    @Test
    void findUsersByUsernameReturnsUserSearchDTOList(){
        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);
        
        //mock
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        List<UserSearchDTO> resultsList = userService.findUsersByUsername(username);

        //Assert
        assertEquals(1, resultsList.size());
    }

    @Test
    void findUsersByUsernameReturnsCorrectUserSearchDTOListUsername(){
        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);
        
        //mock
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        List<UserSearchDTO> resultsList = userService.findUsersByUsername(username);

        //Assert
        assertEquals(expectedSavedUserDocument.getUsername(), resultsList.get(0).getUsername());
    }

    @Test
    void findUsersByUsernameReturnsCorrectUserSearchDTOListWithCorrectBio(){
        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";
        int following = 33;
        int followers = 44;
        String bio = "this is a bio";


        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);
        expectedSavedUserDocument.setBio(bio);
        expectedSavedUserDocument.setFollowers(followers);
        expectedSavedUserDocument.setFollowing(following);
        
        //mock
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        List<UserSearchDTO> resultsList = userService.findUsersByUsername(username);

        //Assert
        assertEquals(bio, resultsList.get(0).getBio());
    }

    @Test
    void findUsersByUsernameReturnsCorrectUserSearchDTOListWithCorrectFollowingCount(){
        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";
        int following = 33;
        int followers = 44;
        String bio = "this is a bio";


        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);
        expectedSavedUserDocument.setBio(bio);
        expectedSavedUserDocument.setFollowers(followers);
        expectedSavedUserDocument.setFollowing(following);
        
        //mock
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        List<UserSearchDTO> resultsList = userService.findUsersByUsername(username);

        //Assert
        assertEquals(following, resultsList.get(0).getFollowing());
    }

    @Test
    void findUsersByUsernameReturnsCorrectUserSearchDTOListWithCorrectFollowerCount(){
        String username = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";
        int following = 33;
        int followers = 44;
        String bio = "this is a bio";


        UserDocument expectedSavedUserDocument = new UserDocument(username, email, password);
        expectedSavedUserDocument.setBio(bio);
        expectedSavedUserDocument.setFollowers(followers);
        expectedSavedUserDocument.setFollowing(following);
        
        //mock
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedSavedUserDocument));

        //Act
        List<UserSearchDTO> resultsList = userService.findUsersByUsername(username);

        //Assert
        assertEquals(followers, resultsList.get(0).getFollowers());
    }

    @Test
    void findUsersByUsernameReturnsEmptyUserSearchDTOList(){
        
        //Arrange
        String username = "wrongUser";

        //mock
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        //Act
        List<UserSearchDTO> resultsList = userService.findUsersByUsername(username);

        //Assert
        assertTrue(resultsList.isEmpty());
    }

    @Test
    void followUserAddsUserToFollowersList(){

        //Arrange
        String localUsername = "localUser";
        String localEmail = "user@gmail.com";
        String targetUsername = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument localUserDocument = new UserDocument(localUsername, localEmail, password);
        UserDocument targetUserDocument = new UserDocument(targetUsername, email, password);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.followUser(localUsername, targetUsername);

        //Assert
        assertTrue(targetUserDocument.getFollowersList().contains(localUsername));

    }


    @Test
    void  followUserAddsToFollowersCount(){

        //Arrange
        String localUsername = "localUser";
        String localEmail = "user@gmail.com";
        String targetUsername = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument localUserDocument = new UserDocument(localUsername, localEmail, password);
        UserDocument targetUserDocument = new UserDocument(targetUsername, email, password);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.followUser(localUsername, targetUsername);

        //Assert
        assertEquals(1, targetUserDocument.getFollowers());

    }

    @Test
    void followUserAddsUserToFollowingList(){

        //Arrange
        String localUsername = "localUser";
        String localEmail = "user@gmail.com";
        String targetUsername = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument localUserDocument = new UserDocument(localUsername, localEmail, password);
        UserDocument targetUserDocument = new UserDocument(targetUsername, email, password);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.followUser(localUsername, targetUsername);

        //Assert
        assertTrue(localUserDocument.getFollowingList().contains(targetUsername));

    }

    @Test
    void followUserAddsToFollowingCount(){

        //Arrange
        String localUsername = "localUser";
        String localEmail = "user@gmail.com";
        String targetUsername = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument localUserDocument = new UserDocument(localUsername, localEmail, password);
        UserDocument targetUserDocument = new UserDocument(targetUsername, email, password);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.followUser(localUsername, targetUsername);

        //Assert
        assertEquals(localUserDocument.getFollowing(), 1);

    }

    @Test
    void followUserThrowsExceptionForNoLocalUser(){
        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument targetUserDocument = new UserDocument(targetUsername, email, password);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.empty());
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        assertThrows(IllegalArgumentException.class, () -> {
            userService.followUser(localUsername, targetUsername);
        });
    }

    @Test
    void followUserThrowsExceptionForNoTargetUser(){
        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        String password = "password";
        String email = "user1@gmail.com";

        UserDocument localUserDocument = new UserDocument(localUsername, email, password);

        //Mock
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.empty());
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));

        assertThrows(IllegalArgumentException.class, () -> {
            userService.followUser(localUsername, targetUsername);
        });
    }

    @Test
    void unfollowUserRemovesFromFollowingCount(){

        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        List<String> targetUsernameFollowersList = new ArrayList<>(Arrays.asList(localUsername));
        List<String> localUsernameFollowingList = new ArrayList<>(Arrays.asList(targetUsername));


        UserDocument localUserDocument = new UserDocument();
        localUserDocument.setUsername(localUsername);
        localUserDocument.setFollowingList(localUsernameFollowingList);
        localUserDocument.setFollowing(1);

        UserDocument targetUserDocument = new UserDocument();
        targetUserDocument.setUsername(targetUsername);
        targetUserDocument.setFollowersList(targetUsernameFollowersList);
        targetUserDocument.setFollowers(1);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.unfollowUser(localUsername, targetUsername);

        //Assert
        assertEquals(localUserDocument.getFollowing(), 0);

    }

    @Test
    void unfollowUserRemovesFromFollowersCount(){

        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        List<String> targetUsernameFollowersList = new ArrayList<>(Arrays.asList(localUsername));
        List<String> localUsernameFollowingList = new ArrayList<>(Arrays.asList(targetUsername));


        UserDocument localUserDocument = new UserDocument();
        localUserDocument.setUsername(localUsername);
        localUserDocument.setFollowingList(localUsernameFollowingList);
        localUserDocument.setFollowing(1);

        UserDocument targetUserDocument = new UserDocument();
        targetUserDocument.setUsername(targetUsername);
        targetUserDocument.setFollowersList(targetUsernameFollowersList);
        targetUserDocument.setFollowers(1);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.unfollowUser(localUsername, targetUsername);

        //Assert
        assertEquals(targetUserDocument.getFollowers(), 0);

    }

    @Test
    void unfollowUserRemovesUsernameFromFollowersList(){

        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        List<String> targetUsernameFollowersList = new ArrayList<>(Arrays.asList(localUsername));
        List<String> localUsernameFollowingList = new ArrayList<>(Arrays.asList(targetUsername));


        UserDocument localUserDocument = new UserDocument();
        localUserDocument.setUsername(localUsername);
        localUserDocument.setFollowingList(localUsernameFollowingList);
        localUserDocument.setFollowing(1);

        UserDocument targetUserDocument = new UserDocument();
        targetUserDocument.setUsername(targetUsername);
        targetUserDocument.setFollowersList(targetUsernameFollowersList);
        targetUserDocument.setFollowers(1);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.unfollowUser(localUsername, targetUsername);

        //Assert
        assertFalse(targetUserDocument.getFollowersList().contains(localUsername));

    }

    @Test
    void unfollowUserRemovesUsernameFromFollowingList(){

        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        List<String> targetUsernameFollowersList = new ArrayList<>(Arrays.asList(localUsername));
        List<String> localUsernameFollowingList = new ArrayList<>(Arrays.asList(targetUsername));


        UserDocument localUserDocument = new UserDocument();
        localUserDocument.setUsername(localUsername);
        localUserDocument.setFollowingList(localUsernameFollowingList);
        localUserDocument.setFollowing(1);

        UserDocument targetUserDocument = new UserDocument();
        targetUserDocument.setUsername(targetUsername);
        targetUserDocument.setFollowersList(targetUsernameFollowersList);
        targetUserDocument.setFollowers(1);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        //Act
        userService.unfollowUser(localUsername, targetUsername);

        //Assert
        assertFalse(localUserDocument.getFollowersList().contains(targetUsername));

    }

    @Test
    void unfollowNonExistingUserThrowsException(){

        //Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";


        UserDocument localUserDocument = new UserDocument();
        localUserDocument.setUsername(localUsername);

        //Mock
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.empty());

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userService.unfollowUser(localUsername, targetUsername);
        });

    }

    @Test
    void getFollowedUsersReturnsFollowingList(){
        UserDocument userDocument = new UserDocument();
        userDocument.setUsername("UserTest");
        userDocument.setFollowingList(Arrays.asList("FollowedUserNumero1", "FollowedUserNumero2"));

        when(userRepository.findByUsername("UserTest")).thenReturn(Optional.of(userDocument));

        List<String> followedUsersResultList = userService.getFollowedUsers("UserTest");

        assertEquals(userDocument.getFollowingList(), followedUsersResultList);

    }

    @Test
    void getFollowedUsersThrowsErrorAtNonExistingUser(){
        String username = "RandomUsername";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            userService.getFollowedUsers(username);
        });
    }

    @Test
    void followUserInitializesFollowersListIfNull() {
        // Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        UserDocument localUserDocument = new UserDocument(localUsername, "localuser@gmail.com", "password");
        UserDocument targetUserDocument = new UserDocument(targetUsername, "usertest1@gmail.com", "password");
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        // Act
        userService.followUser(localUsername, targetUsername);

        // Assert
        assertNotNull(targetUserDocument.getFollowersList());
    }

    @Test
    void followUserInitializesFollowingListIfNull() {
        // Arrange
        String localUsername = "localUser";
        String targetUsername = "UserTest1";
        UserDocument localUserDocument = new UserDocument(localUsername, "localuser@gmail.com", "password");
        UserDocument targetUserDocument = new UserDocument(targetUsername, "usertest1@gmail.com", "password");
        when(userRepository.findByUsername(localUsername)).thenReturn(Optional.of(localUserDocument));
        when(userRepository.findByUsername(targetUsername)).thenReturn(Optional.of(targetUserDocument));

        // Act
        userService.followUser(localUsername, targetUsername);

        // Assert
        assertNotNull(localUserDocument.getFollowingList());
    }

}
