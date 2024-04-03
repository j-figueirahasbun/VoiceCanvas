package com.ip.VoiceCanvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith({MockitoExtension.class})
public class AudioPostServiceTest {
    //TO-DO: Implement unit tests for AudioPostServiceusing mockito

    @InjectMocks
    private AudioPostService audioPostService;  

    @Mock
    private AudioPostRepository audioPostRepository;

    @Mock
    private AudioPostMapper audioPostMapper;

    @Mock
    private UserService userService;

    @SuppressWarnings("null")
    @Test
    void testCreateAudioPostNotNull(){


        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";

        //Make a sample audiopost to test
        AudioPost mockAudioPost = new AudioPost(username, date, audioData);

        //Mock the audiopostrepository behavior
        AudioPostDocument savedAudioPostDocument = new AudioPostDocument(username, date, audioData);
        when(audioPostRepository.save(any(AudioPostDocument.class))).thenReturn(savedAudioPostDocument);

        AudioPost createdAudioPost = audioPostService.createAudioPost(mockAudioPost);

        verify(audioPostRepository).save(any(AudioPostDocument.class));

        assertNotNull(createdAudioPost);
    }

    @SuppressWarnings("null")
    @Test
    void testCreateAudioHasCorrectUsername(){

        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";

        //Make a sample audiopost to test
        AudioPost mockAudioPost = new AudioPost(username, date, audioData);

        //Mock the audiopostrepository behavior
        AudioPostDocument savedAudioPostDocument = new AudioPostDocument(username, date, audioData);
        when(audioPostRepository.save(any(AudioPostDocument.class))).thenReturn(savedAudioPostDocument);

        AudioPost createdAudioPost = audioPostService.createAudioPost(mockAudioPost);

        assertEquals(createdAudioPost.getUsername(), mockAudioPost.getUsername());
    }

    @SuppressWarnings("null")
    @Test
    void testCreateAudioHasCorrectAudioData(){

        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";

        //Make a sample audiopost to test
        AudioPost mockAudioPost = new AudioPost(username, date, audioData);

        //Mock the audiopostrepository behavior
        AudioPostDocument savedAudioPostDocument = new AudioPostDocument(username, date, audioData);
        when(audioPostRepository.save(any(AudioPostDocument.class))).thenReturn(savedAudioPostDocument);

        AudioPost createdAudioPost = audioPostService.createAudioPost(mockAudioPost);

        assertEquals(createdAudioPost.getAudioData(), mockAudioPost.getAudioData());
    }

    @SuppressWarnings("null")
    @Test
    void testCreateAudioHasCorrectDate(){

        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";

        //Make a sample audiopost to test
        AudioPost mockAudioPost = new AudioPost(username, date, audioData);

        //Mock the audiopostrepository behavior
        AudioPostDocument savedAudioPostDocument = new AudioPostDocument(username, date, audioData);
        when(audioPostRepository.save(any(AudioPostDocument.class))).thenReturn(savedAudioPostDocument);

        AudioPost createdAudioPost = audioPostService.createAudioPost(mockAudioPost);

        assertEquals(createdAudioPost.getDate(), mockAudioPost.getDate());
    }

    @Test
    void testFindAudiosByUsernameHasCorrectUsername() {
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List <AudioPostDocument> audioPostDocuments = new ArrayList<>();
        audioPostDocuments.add(new AudioPostDocument(username, date, audioData));
        audioPostDocuments.add(new AudioPostDocument(username, date, audioDataTwo));
        when(audioPostRepository.findByUsername(username)).thenReturn(audioPostDocuments);

        List<AudioPost> expectedAudioPosts = new ArrayList<>();
        expectedAudioPosts.add(new AudioPost(username, date, audioData));
        expectedAudioPosts.add(new AudioPost(username, date, audioDataTwo));

        List<AudioPost> actualAudioPosts = audioPostService.findAudiosByUsername(username);

        assertEquals(expectedAudioPosts.get(0).getUsername(), actualAudioPosts.get(0).getUsername());

    }

    @Test
    void testFindAudiosByUsernameHasCorrectAudioData() {
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List <AudioPostDocument> audioPostDocuments = new ArrayList<>();
        audioPostDocuments.add(new AudioPostDocument(username, date, audioData));
        audioPostDocuments.add(new AudioPostDocument(username, date, audioDataTwo));
        when(audioPostRepository.findByUsername(username)).thenReturn(audioPostDocuments);

        List<AudioPost> expectedAudioPosts = new ArrayList<>();
        expectedAudioPosts.add(new AudioPost(username, date, audioData));
        expectedAudioPosts.add(new AudioPost(username, date, audioDataTwo));

        List<AudioPost> actualAudioPosts = audioPostService.findAudiosByUsername(username);

        assertEquals(expectedAudioPosts.get(1).getAudioData(), actualAudioPosts.get(1).getAudioData());

    }

    @Test
    void testFindAudiosByUsernameHasDifferentAudioDataForDifferentAudioPosts() {
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List <AudioPostDocument> audioPostDocuments = new ArrayList<>();
        audioPostDocuments.add(new AudioPostDocument(username, date, audioData));
        audioPostDocuments.add(new AudioPostDocument(username, date, audioDataTwo));
        when(audioPostRepository.findByUsername(username)).thenReturn(audioPostDocuments);

        List<AudioPost> expectedAudioPosts = new ArrayList<>();
        expectedAudioPosts.add(new AudioPost(username, date, audioData));
        expectedAudioPosts.add(new AudioPost(username, date, audioDataTwo));

        List<AudioPost> actualAudioPosts = audioPostService.findAudiosByUsername(username);

        assertNotEquals(expectedAudioPosts.get(0).getAudioData(), actualAudioPosts.get(1).getAudioData());

    }

    @Test
    void testFindAudiosOfFollowedUsers(){
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List<String> followedUsers = Arrays.asList("User1", "User2");
        List<AudioPostDocument> audioPostDocumentsUser1 = Arrays.asList(
            new AudioPostDocument("User1", date, audioData)
        );
        List<AudioPostDocument> audioPostDocumentsUser2 = Arrays.asList(
            new AudioPostDocument("User2", date, audioDataTwo)
        );

        List<AudioPost> audioPostsUser1 = Arrays.asList(
            new AudioPost("User1", date, audioData)
        ); 
        List<AudioPost> audioPostsUser2 = Arrays.asList(
            new AudioPost("User2", date, audioDataTwo)
        ); 


        try(MockedStatic<AudioPostMapper> mocked = mockStatic(AudioPostMapper.class)){
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser1)).thenReturn(audioPostsUser1);
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser2)).thenReturn(audioPostsUser2);
        
            //mockUserService
            when(userService.getFollowedUsers(username)).thenReturn(followedUsers);

            //Mockbehaviorrepository
            when(audioPostRepository.findByUsername("User1")).thenReturn(audioPostDocumentsUser1);
            when(audioPostRepository.findByUsername("User2")).thenReturn(audioPostDocumentsUser2);

            List <AudioPost> result = audioPostService.findAudiosOfFollowedUsers(username);

            assertEquals(2, result.size());
        
        }

    }

    @Test
    void testFindAudiosOfFollowedHasCorrectUsername(){
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List<String> followedUsers = Arrays.asList("User1", "User2");
        List<AudioPostDocument> audioPostDocumentsUser1 = Arrays.asList(
            new AudioPostDocument("User1", date, audioData)
        );
        List<AudioPostDocument> audioPostDocumentsUser2 = Arrays.asList(
            new AudioPostDocument("User2", date, audioDataTwo)
        );

        List<AudioPost> audioPostsUser1 = Arrays.asList(
            new AudioPost("User1", date, audioData)
        ); 
        List<AudioPost> audioPostsUser2 = Arrays.asList(
            new AudioPost("User2", date, audioDataTwo)
        ); 


        try(MockedStatic<AudioPostMapper> mocked = mockStatic(AudioPostMapper.class)){
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser1)).thenReturn(audioPostsUser1);
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser2)).thenReturn(audioPostsUser2);
        
            //mockUserService
            when(userService.getFollowedUsers(username)).thenReturn(followedUsers);

            //Mockbehaviorrepository
            when(audioPostRepository.findByUsername("User1")).thenReturn(audioPostDocumentsUser1);
            when(audioPostRepository.findByUsername("User2")).thenReturn(audioPostDocumentsUser2);

            List <AudioPost> result = audioPostService.findAudiosOfFollowedUsers(username);

            assertEquals(result.get(1).getUsername(), audioPostsUser2.get(0).getUsername());
        
        }

    }

    @Test
    void testFindAudiosOfFollowedHasCorrectAudioData(){
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List<String> followedUsers = Arrays.asList("User1", "User2");
        List<AudioPostDocument> audioPostDocumentsUser1 = Arrays.asList(
            new AudioPostDocument("User1", date, audioData)
        );
        List<AudioPostDocument> audioPostDocumentsUser2 = Arrays.asList(
            new AudioPostDocument("User2", date, audioDataTwo)
        );

        List<AudioPost> audioPostsUser1 = Arrays.asList(
            new AudioPost("User1", date, audioData)
        ); 
        List<AudioPost> audioPostsUser2 = Arrays.asList(
            new AudioPost("User2", date, audioDataTwo)
        ); 


        try(MockedStatic<AudioPostMapper> mocked = mockStatic(AudioPostMapper.class)){
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser1)).thenReturn(audioPostsUser1);
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser2)).thenReturn(audioPostsUser2);
        
            //mockUserService
            when(userService.getFollowedUsers(username)).thenReturn(followedUsers);

            //Mockbehaviorrepository
            when(audioPostRepository.findByUsername("User1")).thenReturn(audioPostDocumentsUser1);
            when(audioPostRepository.findByUsername("User2")).thenReturn(audioPostDocumentsUser2);

            List <AudioPost> result = audioPostService.findAudiosOfFollowedUsers(username);

            assertEquals(result.get(1).getAudioData(), audioPostsUser2.get(0).getAudioData());
        
        }

    }

    @Test
    void testFindAudiosOfFollowedHasDifferentAudioDataForDifferentEntries(){
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String username = "EvangelineFox";
        
        List<String> followedUsers = Arrays.asList("User1", "User2");
        List<AudioPostDocument> audioPostDocumentsUser1 = Arrays.asList(
            new AudioPostDocument("User1", date, audioData)
        );
        List<AudioPostDocument> audioPostDocumentsUser2 = Arrays.asList(
            new AudioPostDocument("User2", date, audioDataTwo)
        );

        List<AudioPost> audioPostsUser1 = Arrays.asList(
            new AudioPost("User1", date, audioData)
        ); 
        List<AudioPost> audioPostsUser2 = Arrays.asList(
            new AudioPost("User2", date, audioDataTwo)
        ); 


        try(MockedStatic<AudioPostMapper> mocked = mockStatic(AudioPostMapper.class)){
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser1)).thenReturn(audioPostsUser1);
            mocked.when(() -> AudioPostMapper.toAudioPosts(audioPostDocumentsUser2)).thenReturn(audioPostsUser2);
        
            //mockUserService
            when(userService.getFollowedUsers(username)).thenReturn(followedUsers);

            //Mockbehaviorrepository
            when(audioPostRepository.findByUsername("User1")).thenReturn(audioPostDocumentsUser1);
            when(audioPostRepository.findByUsername("User2")).thenReturn(audioPostDocumentsUser2);

            List <AudioPost> result = audioPostService.findAudiosOfFollowedUsers(username);

            assertNotEquals(result.get(1).getAudioData(), result.get(0).getAudioData());
        
        }

    }
    

}
