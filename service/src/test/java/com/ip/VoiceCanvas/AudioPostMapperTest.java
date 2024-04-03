package com.ip.VoiceCanvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class AudioPostMapperTest {
    
    @Test
    void mappingToAudioPostCreatesAudioPostObject(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPostDocument mockAudioDocument = new AudioPostDocument(mockUser.getUsername(), date, audioData);
        AudioPost mockAudioPost = AudioPostMapper.toAudioPost(mockAudioDocument);

        assertNotNull(mockAudioPost);
    }

    @Test
    void mappingToAudioPostMapsOwner(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPostDocument mockAudioDocument = new AudioPostDocument(mockUser.getUsername(), date, audioData);
        AudioPost mockAudioPost = AudioPostMapper.toAudioPost(mockAudioDocument);

        assertEquals(mockAudioPost.getUsername(), mockAudioDocument.getUsername());
    }

    @Test
    void mappingToAudioPostMapsDate(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPostDocument mockAudioDocument = new AudioPostDocument(mockUser.getUsername(), date, audioData);
        AudioPost mockAudioPost = AudioPostMapper.toAudioPost(mockAudioDocument);

        assertEquals(mockAudioPost.getDate(), mockAudioDocument.getDate());
    }

    @Test
    void mappingToAudioPostMapsAudioData(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPostDocument mockAudioDocument = new AudioPostDocument(mockUser.getUsername(), date, audioData);
        AudioPost mockAudioPost = AudioPostMapper.toAudioPost(mockAudioDocument);

        assertEquals(mockAudioPost.getAudioData(), mockAudioDocument.getAudioData());
    }

    @Test
    void mappingToAudioPostDocumentCreatesAudioPostDocumentObject(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPost mockAudioPost = new AudioPost(mockUser.getUsername(), date, audioData);
        
        AudioPostDocument mockAudioPostDocument = AudioPostMapper.toAudioPostDocument(mockAudioPost);

        assertNotNull(mockAudioPostDocument);
    }

    @Test
    void mappingToAudioPostDocumentMapsOwner(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPost mockAudioPost = new AudioPost(mockUser.getUsername(), date, audioData);
        
        AudioPostDocument mockAudioPostDocument = AudioPostMapper.toAudioPostDocument(mockAudioPost);

        assertEquals(mockAudioPostDocument.getUsername(), mockAudioPost.getUsername());
    }

    @Test
    void mappingToAudioPostDocumentMapsDate(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPost mockAudioPost = new AudioPost(mockUser.getUsername(), date, audioData);
        
        AudioPostDocument mockAudioPostDocument = AudioPostMapper.toAudioPostDocument(mockAudioPost);

        assertEquals(mockAudioPostDocument.getDate(), mockAudioPost.getDate());
    }

    @Test
    void mappingToAudioPostDocumentMapsAudioData(){
        User mockUser = new User("EvangelineFortuna11", 
        "evangeline@gmail.com" , "woodvale123");
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";

        AudioPost mockAudioPost = new AudioPost(mockUser.getUsername(), date, audioData);
        
        AudioPostDocument mockAudioPostDocument = AudioPostMapper.toAudioPostDocument(mockAudioPost);

        assertEquals(mockAudioPostDocument.getAudioData(), mockAudioPost.getAudioData());
    }

    @Test
    void mappingListOfAudioPostDocumentsToAudioPostsMapsCorrectSize(){
        
        //Arrange
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        AudioPostDocument mockAudioPostDocumentOne = new AudioPostDocument("EvangelineFox", date, audioData);
        AudioPostDocument mockAudioPostDocumentTwo = new AudioPostDocument("AuroraValor", date, audioData);
        
        List<AudioPostDocument> mockAudioPostDocuments = new ArrayList<>();
        mockAudioPostDocuments.add(mockAudioPostDocumentOne);
        mockAudioPostDocuments.add(mockAudioPostDocumentTwo);

        //Act
        List<AudioPost> mockAudioPosts = AudioPostMapper.toAudioPosts(mockAudioPostDocuments);

        //Assert
        assertEquals(mockAudioPostDocuments.size(), mockAudioPosts.size());

    }

    @Test
    void mappingListOfAudioPostDocumentsToAudioPostsMapsCorrectUsername(){
        
        //Arrange
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        AudioPostDocument mockAudioPostDocumentOne = new AudioPostDocument("EvangelineFox", date, audioData);
        AudioPostDocument mockAudioPostDocumentTwo = new AudioPostDocument("AuroraValor", date, audioData);
        
        List<AudioPostDocument> mockAudioPostDocuments = new ArrayList<>();
        mockAudioPostDocuments.add(mockAudioPostDocumentOne);
        mockAudioPostDocuments.add(mockAudioPostDocumentTwo);

        //Act
        List<AudioPost> mockAudioPosts = AudioPostMapper.toAudioPosts(mockAudioPostDocuments);

        //Assert
        assertEquals(mockAudioPostDocumentOne.getUsername(), mockAudioPosts.get(0).getUsername());

    }

    @Test
    void mappingListOfAudioPostDocumentsToAudioPostsMapsCorrectDate(){
        
        //Arrange
        Date date = new Date();
        String audioData = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        AudioPostDocument mockAudioPostDocumentOne = new AudioPostDocument("EvangelineFox", date, audioData);
        AudioPostDocument mockAudioPostDocumentTwo = new AudioPostDocument("AuroraValor", date, audioData);
        
        List<AudioPostDocument> mockAudioPostDocuments = new ArrayList<>();
        mockAudioPostDocuments.add(mockAudioPostDocumentOne);
        mockAudioPostDocuments.add(mockAudioPostDocumentTwo);

        //Act
        List<AudioPost> mockAudioPosts = AudioPostMapper.toAudioPosts(mockAudioPostDocuments);

        //Assert
        assertEquals(mockAudioPostDocumentOne.getDate(), mockAudioPosts.get(0).getDate());

    }

    @Test
    void mappingListOfAudioPostDocumentsToAudioPostsMapsCorrectAudioData(){
        
        //Arrange
        Date date = new Date();
        String audioDataOne = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQAAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        String audioDataTwo = "/+MYxAAEaAIEeUAQAgBgNgP/////KQQ/////Lvrg+lcWYHgtjadzsbTq+yREu495tq9c6v/7vt/of7mna9v6/btUnU17Jun9/+MYxCkT26KW+YGBAj9v6vUh+zab//v/96C3/pu6H+pv//r/ycIIP4pcWWTRBBBAMXgNdbRaABQBAABRWKwgjQVX0ECmrb///+MYxBQSM0sWWYI4A++Z/////////////0rOZ3MP//7H44QEgxgdvRVMXHZseL//540B4JAvMPEgaA4/0nHjxLhRgAoAYAgA/+MYxAYIAAJfGYEQAMAJAIAQMAwX936/q/tWtv/2f/+v//6v/+7qTEFNRTMuOTkuNVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV";
        AudioPostDocument mockAudioPostDocumentOne = new AudioPostDocument("EvangelineFox", date, audioDataOne);
        AudioPostDocument mockAudioPostDocumentTwo = new AudioPostDocument("AuroraValor", date, audioDataTwo);
        
        List<AudioPostDocument> mockAudioPostDocuments = new ArrayList<>();
        mockAudioPostDocuments.add(mockAudioPostDocumentOne);
        mockAudioPostDocuments.add(mockAudioPostDocumentTwo);

        //Act
        List<AudioPost> mockAudioPosts = AudioPostMapper.toAudioPosts(mockAudioPostDocuments);

        //Assert
        assertEquals(mockAudioPostDocumentTwo.getAudioData(), mockAudioPosts.get(1).getAudioData());

    }
    


}
