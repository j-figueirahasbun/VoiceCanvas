import React, { useEffect, useState } from 'react';
import '../App.css';
import apiService from '../services/apiService';
import AudioRecorder from '../components/AudioRecorder';
import {RouteProps} from 'react-router-dom';
import Sidebar from '../components/ProfileSideBar';
import AudioRetriever from '../components/AudioRetriever';
import TopBar from '../components/Topbar';

const Feed: React.FC <RouteProps> = () => {
  const [fetchedText, setFetchedText] = useState<string | null>(null);
  const [username, setUsername] = useState<string | null>(null);
  
    useEffect(() => {
        const storedUsername = localStorage.getItem('username');
        setUsername(storedUsername);
    }, []);

    const handleButtonClick = async () => {
    try {
        const text = await apiService.getText();
        setFetchedText(text);
    } catch (error) {
        console.error('Error fetching text:', error);
    }
    };

    return (
        <>
            <Sidebar/>
            <TopBar/>
            <div className=''>
            <div className='w-10'>
            <AudioRetriever  />
            </div>
            </div>
        </>
    );
}

export default Feed;