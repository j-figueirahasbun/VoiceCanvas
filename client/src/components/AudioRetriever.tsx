// AudioRetriever.tsx
import React, { useState, useEffect } from 'react';
import apiService from '../services/apiService';

import AudioPlayer from './AudioPlayer';

const AudioRetriever: React.FC = () => {
  const [audioList, setAudioList] = useState<string[]>([]);

  // const getAudio = async () => {
  //   try {
  //     const username = localStorage.getItem('username');
      
  //     if (username) {
  //       const audios = await apiService.getAudiosByUsername(username);
  //       console.log('Audios retrieved', audios);
  //       // eslint-disable-next-line
  //       const audioDataWithBlobs = await Promise.all(audios.map(async (audioObj: any) => {
  //         const blob = base64ToBlob(audioObj.audioData);
  //         const url = URL.createObjectURL(blob);
  //         return url;
  //       }));
  //       setAudioList(audioDataWithBlobs);
  //     } else {
  //       console.error('Username could not be used to retrieve audios.');
  //     }
  //   } catch(error) {
  //     console.error ('Error retrieving audios:', error)
  //   } 
  // }

  const getAudiosOfFollowedUsers = async () => {
    try {
      const username = localStorage.getItem('username');
      if (username) {
        const audios = await apiService.getAudiosOfFollowedUsers(username);
        console.log('Audios retrieved', audios);
        const audioDataWithBlobs = await Promise.all(audios.map(async (audioObj: any) => {
          const blob = base64ToBlob(audioObj.audioData);
          const url = URL.createObjectURL(blob);
          return url;
        }));
        setAudioList(audioDataWithBlobs);
      } else {
        console.error('Username could not be used to retrieve audios.');
      }
    } catch(error) {
      console.error('Error retrieving audios:', error)
    } 
  }

  function base64ToBlob(base64String: string): Blob {
    const byteCharacters = atob(base64String);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);
    return new Blob([byteArray], { type: "audio/webm" });
  }

  useEffect(() => {
    getAudiosOfFollowedUsers();
  }, []);

  return (
    <div className="mt-4 absolute top-16 left-96 w-9/12 md:ml-4 lg:ml-8">
      {/* <h3 className="text-lg font-semibold">Recorded Audios</h3> */}
      {audioList.map((audioUrl, index) => (
        <div key={index} className="mt-2">
          {/* <audio src={audioUrl} controls className="outline-black"></audio> */}
          <AudioPlayer audioUrl={audioUrl}/>
        </div>
      ))}
    </div>
  );
};

export default AudioRetriever;
