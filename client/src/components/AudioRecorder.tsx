// AudioRecorder.tsx
import React, { useState, useEffect, useRef } from 'react';
import apiService from '../services/apiService';

const AudioRecorder: React.FC = () => {
  const [stream, setStream] = useState<MediaStream | null>(null);
  const [permission, setPermission] = useState(false);
  const mediaRecorder = useRef<MediaRecorder | null>(null);
  const [recordingStatus, setRecordingStatus] = useState<"inactive" | "recording">("inactive");
  // eslint-disable-next-line
  const [audioChunks, setAudioChunks] = useState<Blob[]>([]);
  // eslint-disable-next-line
  const [audio, setAudio] = useState<string | null>(null);
  const [showRetrieveButton, setShowRetrieveButton] = useState(false); //manage visibility
  const [audioList, setAudioList] = useState<string[]>([]); 

  const mimeType = "audio/webm";

  const getMicrophonePermission = async () => {
    if ("MediaRecorder" in window) {
      try {
        const streamData = await navigator.mediaDevices.getUserMedia({
          audio: true,
          video: false,
        });
        setStream(streamData);
        setPermission(true);
      } catch (err) {
        alert((err as Error).message);
      }
    } else {
      alert("The MediaRecorder API is not supported in your browser.");
    }
  };

  useEffect(() => {
    getMicrophonePermission();
  }, []);

  const startRecording = () => {
    if (stream) {
      setRecordingStatus("recording");
      const mediaOptions: MediaRecorderOptions = { mimeType }; 
      const media = new MediaRecorder(stream, mediaOptions);
      mediaRecorder.current = media;
      const localAudioChunks: Blob[] = [];
      mediaRecorder.current.ondataavailable = (event) => {
        if (event.data.size > 0) {
          localAudioChunks.push(event.data);
        }
      };

      mediaRecorder.current.onstop =  async () => {
        const audioBlob = new Blob(localAudioChunks, { type: mimeType });
        setShowRetrieveButton(true);
        try {
          const audioBase64String = await blobToBase64(audioBlob);
          sendAudio(audioBase64String);
        } catch (error){
          console.error("Error converting Blob to Base64 string.", error);
        }
      };
      mediaRecorder.current.start();
    }
  };

  const stopRecording = () => {
    if (mediaRecorder.current && recordingStatus === "recording") {
      setRecordingStatus("inactive");
      mediaRecorder.current.stop();
    }
  };

  const sendAudio = async (audioBase64String: string) => {
    try { 
      const username = localStorage.getItem('username');
      if (!username) {
        throw new Error('Username not found');
      }
      const date = new Date();
      
      try {
        //Send base64 string to the backend
        await apiService.createAudioPost(username, date, audioBase64String);
        console.log('Audio uploaded successfully');
      } catch (error) {
        console.error('Error uploading audio:', error)
      }
    } catch (error) {
      console.error('Error uploading audio:', error)
    }
  };

  function blobToBase64(audioBlob: Blob): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      const reader = new FileReader();
      reader.onload = () => {
        const base64String = btoa(
          new Uint8Array(reader.result as ArrayBuffer).reduce((data, byte) => {
            return data + String.fromCharCode(byte);
          }, '')
        );
        resolve(base64String);
      };
      reader.onerror = reject;
      reader.readAsArrayBuffer(audioBlob);
    });
  }
  
  return (
    <div className="flex flex-col items-center justify-center">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
      <div className="mt-2 sm:mx-auto sm:w-full sm:max-w-sm">
        <div className="flex flex-col items-center space-y-2">
          {!permission ? (
            <button onClick={getMicrophonePermission} className="flex w-full justify-center rounded-md bg-custom-accent px-3 py-1.5 text-sm font-semibold leading-6
             text-white shadow-sm hover:bg-custom-accentlight focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2
              focus-visible:outline-custom-accent">Get Microphone Permission</button>
          ) : null}
          {permission && recordingStatus === "inactive" ? (
            <button onClick={startRecording} className="flex w-full justify-center rounded-md bg-custom-accent px-3 py-1.5 text-sm font-semibold leading-6 
            text-white shadow-sm hover:bg-custom-accentlight focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 
            focus-visible:outline-custom-accent">Record an audio</button>
          ) : null}
          {recordingStatus === "recording" ? (
            <button onClick={stopRecording} className="flex w-full justify-center rounded-md bg-custom-accent px-3 py-1.5 text-sm font-semibold leading-6
             text-white shadow-sm hover:bg-custom-accentlight focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 
             focus-visible:outline-custom-accent">Stop Recording</button>
          ) : null}
        </div>
        </div>
        </div>
        </div>
  );
};

export default AudioRecorder;
