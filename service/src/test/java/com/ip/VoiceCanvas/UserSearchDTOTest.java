package com.ip.VoiceCanvas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserSearchDTOTest {
    

    @Test
    void UserSearchDTOHasCorrectUsername(){
    String username = "EvangelineFox";
    int followers = 45;
    int following = 33;
    String bio = "This is a bio";

    UserSearchDTO mockDTO = new UserSearchDTO(username, followers, following, bio);

    assertEquals(username, mockDTO.getUsername());

    }

    @Test
    void UserSearchDTOHasCorrectFollowersCount(){
    String username = "EvangelineFox";
    int followers = 45;
    int following = 33;
    String bio = "This is a bio";

    UserSearchDTO mockDTO = new UserSearchDTO(username, followers, following, bio);

    assertEquals(followers, mockDTO.getFollowers());

    }

    @Test
    void UserSearchDTOHasCorrectFollowingCount(){
    String username = "EvangelineFox";
    int followers = 45;
    int following = 33;
    String bio = "This is a bio";

    UserSearchDTO mockDTO = new UserSearchDTO(username, followers, following, bio);

    assertEquals(following, mockDTO.getFollowing());

    }

    @Test
    void UserSearchDTOHasCorrectBio(){
    String username = "EvangelineFox";
    int followers = 45;
    int following = 33;
    String bio = "This is a bio";

    UserSearchDTO mockDTO = new UserSearchDTO(username, followers, following, bio);

    assertEquals(bio, mockDTO.getBio());

    }

    @Test
    public void testEmptyConstructor() {
    
        UserSearchDTO userSearchDTO = new UserSearchDTO();

        assertEquals(null, userSearchDTO.getUsername());
        assertEquals(0, userSearchDTO.getFollowers());
        assertEquals(0, userSearchDTO.getFollowing());
        assertEquals(null, userSearchDTO.getBio());
    }

    @Test
    public void testSetUsername() {
        UserSearchDTO userSearchDTO = new UserSearchDTO();

        userSearchDTO.setUsername("testUsername");

        assertEquals("testUsername", userSearchDTO.getUsername());
    }

    @Test
    public void testSetFollowers() {
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        userSearchDTO.setFollowers(100);

        assertEquals(100, userSearchDTO.getFollowers());
    }

    @Test
    public void testSetFollowing() {
        
        UserSearchDTO userSearchDTO = new UserSearchDTO();

        
        userSearchDTO.setFollowing(50);

        assertEquals(50, userSearchDTO.getFollowing());
    }

    @Test
    public void testSetBio() {
        
        UserSearchDTO userSearchDTO = new UserSearchDTO();

        
        userSearchDTO.setBio("testBio");

        
        assertEquals("testBio", userSearchDTO.getBio());
    }
}
