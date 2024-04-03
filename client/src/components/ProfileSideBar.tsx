import React, { useState } from 'react';
import AudioRecorder from './AudioRecorder';
import { useNavigate } from 'react-router-dom';

const Sidebar = () => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const username = localStorage.getItem('username')

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const navigate = useNavigate();

  const handleLogout = () => {
    // Clear localStorage and session
    localStorage.clear();
    sessionStorage.clear();
    // Navigate to '/'
    navigate('/');
  };

  return (
    <>
      {/* Sidebar */}
      <aside
        id="default-sidebar"
        className={`fixed top-0 left-0 z-40 w-96 h-screen transition-transform ${
          isSidebarOpen ? '' : '-translate-x-full sm:translate-x-0'
        }`}
        aria-label="Sidenav"
      >
        <div className="overflow-y-auto py-5 px-3 h-full bg-white border-r border-gray-200 dark:bg-gray-800 dark:border-gray-700">
          <ul className="space-y-2">
        {/* VoiceCanvas */}
        <h2 className="font-bold text-gray-700 dark:text-white text-4xl">
            Profile
          </h2>

          {/* Profile Picture */}
          <div className="mt-4 flex justify-center">
            <div className="h-48 w-48 bg-gray-200 rounded-full"></div>
          </div>

          {/* Welcome Message */}
          {username && (
            <h2 className="mt-2 text-sm text-gray-600 dark:text-gray-400 font-semibold">
              Welcome, {username}!
            </h2>
          )}
            {/* placeholderBio */}
            <h2 className="mt-2 text-sm text-gray-600 dark:text-gray-400">
              Placeholder Bio
            </h2>


        {/**Followers / Following */}
        <div className="flex justify-center items-center">
        <h2 className="text-base font-bold text-gray-700 dark:text-white">
        Followers: 
        {/* {getFollowers()} */}
        </h2>
        <h2 className="mx-2 text-base font-bold text-gray-700 dark:text-white">•</h2>
        <h2 className="text-base font-bold text-gray-700 dark:text-white">
        Following: 
        {/* {getFollowing()} */}
        </h2>
        </div>
        
        {/* Divider line */}
        <hr className="my-4 border-t border-gray-300 dark:border-gray-600" />

        {/* Audio Recorder Component */}
        <AudioRecorder />


            {/* Sidebar items */}
            {/* Replace anchor tags with react-router-dom Link components if using React Router */}
            {/* Logout Button */}

            <li>
                <div className="w-full">
              <button
                onClick={handleLogout}
                className="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
              >
                <svg
                  aria-hidden="true"
                  className="w-6 h-6 text-gray-400 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                  fill="currentColor"
                  viewBox="0 0 20 20"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M8.707 7.293a1 1 0 00-1.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                  ></path>
                  <path
                    d="M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z"
                  ></path>
                </svg>
                <span className="ml-3">Logout</span>
              </button>
              </div>
            </li>
            {/* More sidebar items */}
            {/* Replace anchor tags with react-router-dom Link components if using React Router */}
          </ul>
        </div>
      </aside>
    </>
  );
};

export default Sidebar;
