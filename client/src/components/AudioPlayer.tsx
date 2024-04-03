import * as React from "react";
import { MdPlayArrow, MdPause, MdVolumeUp, MdVolumeOff } from "react-icons/md";
import { CgSpinner } from "react-icons/cg";
import IconButton from "./IconButton";

interface AudioPlayerProps {
  audioUrl: string;
}

interface ProgressCSSProps extends React.CSSProperties {
  "--progress-width": number;
}

export default function AudioPlayer(props: AudioPlayerProps) {
  const audioRef = React.useRef<HTMLAudioElement | null>(null);

  const [duration, setDuration] = React.useState(0);
  const [isReady, setIsReady] = React.useState(false);
  const [isPlaying, setIsPlaying] = React.useState(false);
  const [volume, setVolume] = React.useState(0.2); // set to 0.2, max is 1.0
  const [currrentProgress, setCurrrentProgress] = React.useState(0);
  const [buffered, setBuffered] = React.useState(0);

  const handleVolumeChange = (volumeValue: number) => {
    if (!audioRef.current) return;
    audioRef.current.volume = volumeValue;
    setVolume(volumeValue);
  };

  const handleMuteUnmute = () => {
    if (!audioRef.current) return;
    if (audioRef.current.volume !== 0) {
      audioRef.current.volume = 0;
    } else {
      audioRef.current.volume = 1;
    }
  };

  const togglePlayPause = () => {
    if (isPlaying) {
      audioRef.current?.pause();
      setIsPlaying(false);
    } else {
      audioRef.current?.play();
      setIsPlaying(true);
    }
  };

  const handleBufferProgress: React.ReactEventHandler<HTMLAudioElement> = (e) => {
    const audio = e.currentTarget;
    const dur = audio.duration;
    if (dur > 0) {
      for (let i = 0; i < audio.buffered.length; i++) {
        if (audio.buffered.start(audio.buffered.length - 1 - i) < audio.currentTime) {
          const bufferedLength = audio.buffered.end(audio.buffered.length - 1 - i);
          setBuffered(bufferedLength);
          break;
        }
      }
    }
  };

  const formatDurationDisplay = (duration: number) => {
    const min = Math.floor(duration / 60);
    const sec = Math.floor(duration - min * 60);
    const formatted = [min, sec].map((n) => (n < 10 ? "0" + n : n)).join(":"); // format - mm:ss
    return formatted;
  };

  const elapsedDisplay = formatDurationDisplay(currrentProgress);

  const progressStyles: ProgressCSSProps = {
    "--progress-width": isNaN(currrentProgress / duration) ? 0 : currrentProgress / duration,
  };

  return (
    <div className="bg-custom-light text-custom-dark p-3 shadow-lg rounded-lg w-full mx-auto md:ml-0 md:mr-4">
      <div className="flex justify-between items-center">
        <div className="flex items-center">
          <IconButton
            disabled={!isReady}
            onClick={togglePlayPause}
            aria-label={isPlaying ? "Pause" : "Play"}
            size="lg"
            className="bg-custom-accent"
          >
            {!isReady && !isPlaying ? (
              <CgSpinner size={24} className="animate-spin text-custom-dark" />
            ) : isPlaying ? (
              <MdPause size={30} className="text-custom-dark" />
            ) : (
              <MdPlayArrow size={30} className="text-custom-dark" />
            )}
          </IconButton>
          <span className="text-xs ml-2">{elapsedDisplay}</span>
        </div>
        <input
          type="range"
          className="progress-bar w-full h-1"
          style={{backgroundColor:'#736013', ...progressStyles}}
          min={0}
          max={duration}
          value={currrentProgress}
          onChange={(e) => {
            if (!audioRef.current) return;
            audioRef.current.currentTime = e.currentTarget.valueAsNumber;
            setCurrrentProgress(e.currentTarget.valueAsNumber);
          }}
        />
        <div className="flex items-center">
          <input
            aria-label="volume"
            name="volume"
            type="range"
            min={0}
            step={0.05}
            max={1}
            value={volume}
            className="w-20 h-2 rounded-full accent-custom-accent bg-custom-lightdarker appearance-none cursor-pointer ml-2"
            onChange={(e) => {
              handleVolumeChange(e.currentTarget.valueAsNumber);
            }}
          />
          <IconButton
            intent="secondary"
            size="sm"
            onClick={handleMuteUnmute}
            aria-label={volume === 0 ? "unmute" : "mute"}
            className="ml-2"
          >
            {volume === 0 ? <MdVolumeOff size={20} /> : <MdVolumeUp size={20} />}
          </IconButton>
        </div>
      </div>
      <audio
        ref={audioRef}
        preload="metadata"
        src={props.audioUrl}
        onDurationChange={(e) => setDuration(e.currentTarget.duration)}
        onCanPlay={() => setIsReady(true)}
        onPlaying={() => setIsPlaying(true)}
        onPause={() => setIsPlaying(false)}
        onTimeUpdate={(e) => {
          setCurrrentProgress(e.currentTarget.currentTime);
          handleBufferProgress(e);
        }}
        onProgress={handleBufferProgress}
      />
    </div>
  );
}