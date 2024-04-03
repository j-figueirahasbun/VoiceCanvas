import { XMarkIcon } from '@heroicons/react/24/outline';
import apiService from '../services/apiService';
import { useState } from 'react';

interface SearchedUserProfileSideBarProps {
  user: any;
  closeSidebar: () => void;
}

const SearchedUserProfileSideBar: React.FC<SearchedUserProfileSideBarProps> = ({ user, closeSidebar }) => {
  
  const [isFollowing, setIsFollowing] = useState(false);
  const localusername = localStorage.getItem('username')!;

  const handleFollowButtonClick = async() =>{
    try {
      console.log('Request to Follow User:', user.username);
      const response = await apiService.handleFollowUser(user.username, localusername);
      console.log('Followed user:', user.username);
      setIsFollowing(!isFollowing);
      // eslint-disable-next-line
    } catch (error){
      console.error('Error following user:', user.username)
    }
  };

  const handleUnfollowButtonClick = async () => {
    try {
      console.log('Request to Unfollow User:', user.username);
      const response = await apiService.handleUnfollowUser(user.username, localusername);
      console.log('Unfollowed user:', user.username);
      setIsFollowing(false);
    } catch (error) {
      console.error('Error unfollowing user:', user.username);
    }
  };
  
  return (
    <div className="fixed top-0 right-0 z-50 w-96 h-screen p-4 overflow-y-auto transition-transform bg-white border-l border-gray-200 dark:bg-gray-800">
      <div className="py-4 overflow-y-auto">
        <div className="flex flex-col items-center justify-center relative">
          <h2 className="text-base font-bold text-gray-700 dark:text-white">
            {user.username}
          </h2>
          {/* Close Button */}
          <button
            onClick={closeSidebar}
            className="absolute top-2 right-2 bg-transparent text-gray-500 hover:text-gray-900"
          >
            <XMarkIcon className="h-6 w-6" />
          </button>
          {/* Display user profile */}
          <div className="flex flex-col items-center gap-4 mt-4">
          <div className="mt-4 flex justify-center">
            <div className="h-48 w-48 bg-gray-200 rounded-full"></div>
          </div>
            <p className="text-sm text-gray-600">{user.bio}</p>
            <p className="text-xs text-gray-500">Following: {user.following}, Followers: {user.followers}</p>
          </div>
          {/* Divider line */}
          <hr className="my-4 border-t border-gray-300 dark:border-gray-600" />
          {/* Render follow/unfollow button based on isFollowing state */}
          <button
            className="flex w-full justify-center rounded-md bg-custom-accent px-3 py-1.5 text-sm font-semibold leading-6 
              text-white shadow-sm hover:bg-custom-accentlight focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 
              focus-visible:outline-custom-accent"
            onClick={isFollowing ? handleUnfollowButtonClick : handleFollowButtonClick}>
            {isFollowing ? 'Unfollow' : 'Follow'}
          </button>
        </div>
      </div>
    </div>
  );
};

export default SearchedUserProfileSideBar;
