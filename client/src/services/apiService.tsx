
import axios from 'axios';

const domainapi = 'http://localhost:8080/api';

const apiService = {
    getText: async () => {
      try {
        const response = await axios.get(`${domainapi}/text`);
        
        console.log('Data from domain server:', response.data);
        
        return JSON.stringify(response.data.textToDisplay); // Convert to JSON string
      
        } catch (error) {
        
            console.error('Error fetching data from foreign server:', error);
        
        throw error;
        }
    }, 

    handleSignUp: async (username: string, email: string, password: string) => {
      try {
        const response = await axios.post(`${domainapi}/users/signup`, {username, email, password});
        
        console.log('SignUp successful:', response.data);
        
        return JSON.stringify(response.data.textToDisplay); // Convert to JSON string
      
        } catch (error) {
        
            console.error('Error signing up:', error);
        
        throw error;
        }
    },

    handleLogin: async (username: string, password: string) => {
      try {
        const response = await axios.post(`${domainapi}/users/login`, {username, password});
        
        console.log('Login successful:', response.data);
        
        return JSON.stringify(response.data.textToDisplay); // Convert to JSON string
      
        } catch (error) {
        
            console.error('Error logging in:', error);
        
        throw error;
        }
    },

    createAudioPost: async (username: string, date: Date, audioData: string) => {
      try {
        await axios.post(`${domainapi}/audio/create`, {username, date, audioData});
        
        console.log('Audio uploaded successfully');
      
      } catch (error) {
      
        console.error('Error uploading audio:', error);
      
        throw error;
      }
    },

    getAudiosByUsername: async (username: string) => {
      try {
          const response = await axios.get(`${domainapi}/audio/getAudiosByUsername/${username}`);
          
          console.log('Audio data retrieved:', response.data);
          
          return response.data; // The response data is an array of audio objects
      
        } catch (error) {
          
          console.error('Error fetching audio data:', error);
          
          throw error;
      }
    }, 

    getAudiosOfFollowedUsers: async (username: string) => {
      try {
        const response = await axios.get(`${domainapi}/audio/getAudiosOfFollowedUsers/${username}`);
        
        console.log('Audios of followed users retrieved:', response.data);
        
        return response.data; // The response data is an array of audio objects
      
      } catch (error) {
      
        console.error('Error fetching audios of followed users:', error);
      
        throw error;
      
      }
    
    },

    handleUserSearch: async (userToSearch: string) => {
      try {
        const response = await axios.get(`${domainapi}/users/search/${userToSearch}`);
        
        console.log('Searching user successful:', response.data);
        
        return response.data; 
      
        } catch (error) {
        
            console.error('Error searching user:', error);
        
        throw error;
        }
    },

    handleFollowUser: async(username: string, localusername: string) => {
      try {
        const response = await axios.put(`${domainapi}/users/follow/${username}/${localusername}`);

        console.log('Trying to follow the user', username);

        return response.data;
      
      } catch (error) {
        
        console.error('Error following the user:', error);

        throw error;
      }
    }, 

    handleUnfollowUser: async(username: string, localusername: string) => {
      try {
        const response = await axios.put(`${domainapi}/users/unfollow/${username}/${localusername}`);

        console.log('Trying to unfollow the user', username);

        return response.data;
      
      } catch (error) {
        
        console.error('Error unfollowing the user:', error);

        throw error;
      }
    }, 

    //TODO: Fix Bio Change
    handleBioChange: async(username: string, bio: string) => {
      try {
        const response = await axios.put(`${domainapi}/users/unfollow/${username}/${localusername}`);

        console.log('Trying to unfollow the user', username);

        return response.data;
      
      } catch (error) {
        
        console.error('Error unfollowing the user:', error);

        throw error;
      }
    }
};

export default apiService;
