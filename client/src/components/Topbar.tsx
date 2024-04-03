import { Disclosure } from '@headlessui/react';
import { useState } from 'react';
import { MagnifyingGlassIcon } from '@heroicons/react/24/outline';
import { XMarkIcon } from '@heroicons/react/24/outline';
import apiService from '../services/apiService';
import SearchedUserProfileSideBar from './SearchedUserProfileSideBar';


export default function TopBar() {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const [userToSearch, setUserToSearch] = useState<string>("");

  const [searchResults, setSearchResults] = useState<any[]>([]);

  const [isSearchedUserProfileSideBarOpen, setIsSearchedUserProfileSideBarOpen] = useState(false);
  const [selectedUser, setSelectedUser] = useState<any>(null);

  const openSidebar = () => {
    setIsSidebarOpen(true);
  };

  const closeSidebar = () => {
    setIsSidebarOpen(false);
  };

  const closeSearchedUserProfileSidebar = () => {
    setIsSearchedUserProfileSideBarOpen(false); // Close searched user profile sidebar
  };
  

  const handleButtonClick = async () => {
    try {
        console.log('Searching for User:', userToSearch);
        const userSearchResults = await apiService.handleUserSearch(userToSearch);
        console.log('Searched for User:', userToSearch);
        setSearchResults(userSearchResults);
        // eslint-disable-next-line
    } catch (error){
      console.error('Error searching User:', userToSearch)
    }
  };

  const handleUserProfileClick = async(user: any) => {
    setSelectedUser(user); // Set selected user data
    setIsSearchedUserProfileSideBarOpen(true); // Open profile sidebar
  };

  return (
    <>
      <Disclosure as="nav" className="bg-custom-darker fixed w-full z-10 top-0">
        {({ open }: { open: boolean }) => (
          <>
            <div className="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
              <div className="relative flex h-16 items-center justify-between">
                <div className="flex items-center justify-center ml-80">
                  <img
                    className="h-8 w-auto mr-2"
                    src="../public/audiorecorder_103216.svg"
                    alt="Logo"
                  />
                  <h2 className="font-bold text-custom-light dark:text-white text-4xl">
                    VoiceCanvas
                  </h2>
                </div>
                <div className="flex items-center space-x-4">
                  <div className="hidden sm:block"></div>
                  <button
                    onClick={openSidebar}
                    className="flex items-center text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-inset"
                  >
                    <MagnifyingGlassIcon
                      className="h-6 w-6 mr-2"
                      aria-hidden="true"
                    />
                  </button>
                </div>
              </div>
            </div>
          </>
        )}
      </Disclosure>

      {/* Sidebar */}
      {isSidebarOpen && (
        <div className="fixed top-0 right-0 z-40 w-96 h-screen p-4 overflow-y-auto transition-transform bg-white border-l border-gray-200 dark:bg-gray-800">
          <div className="py-4 overflow-y-auto">
            <div className="flex flex-col items-center justify-center relative">
            <h2 className="text-base font-bold text-gray-700 dark:text-white">
              Search </h2>
              {/* Close Button */}
              <button
                onClick={closeSidebar}
                className="absolute top-2 right-2 bg-transparent text-gray-500 hover:text-gray-900"
              >
                <XMarkIcon className="h-6 w-6" />
              </button>
              {/* Search Bar */}
              <div className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
                <input
                  type="text"
                  placeholder="Search username..."
                  value={userToSearch}
                  onChange={(e) => setUserToSearch(e.target.value)}
                  className="flex-1 px-3 py-2 border border-gray-300 rounded-l-md focus:outline-none focus:ring-blue-500 focus:border-blue-500"
                />
                <button
                  onClick={handleButtonClick} 
                  className="px-3 py-2 bg-custom-accent text-sm font-semibold leading-6 text-white rounded-r-md shadow-sm hover:bg-custom-accentlight focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-custom-accent">
                  Search
                </button>
              </div>

              {/* Display Search Results */}
              <ul role="list" className="divide-y divide-gray-100 mt-4">
                {searchResults.map((user) => (
                  <li key={user.username} className="flex justify-between gap-x-6 py-5">
                    <div className="flex min-w-0 gap-x-4">
                      <div className="min-w-0 flex-auto">
                        <p className="text-sm font-semibold leading-6 text-gray-900">{user.username}</p>
                        <p className="mt-1 truncate text-xs leading-5 text-gray-600">{user.bio}</p>
                        <p className="mt-1 truncate text-xs leading-5 text-gray-500">Following: {user.following}, Followers: {user.followers}</p>
                        <p className="mt-1 text-xs leading-5 text-gray-500">{user.bio}</p>
                      </div>
                      {/* Render button for each user */}
                      <button
                        onClick={() => handleUserProfileClick(user)}
                        className="px-3 py-1 bg-custom-accent text-xs font-semibold leading-4 text-white rounded-md shadow-sm hover:bg-custom-accentlight focus-visible:outline focus-visible:ring focus-visible:ring-blue-500 focus-visible:ring-opacity-50">
                        View Profile
                      </button>
                    </div>
                  </li>
                ))}
              </ul>
            </div>
          </div>
        </div>
      )}

      {/* Profile Sidebar */}
      {isSearchedUserProfileSideBarOpen && selectedUser && (
        <SearchedUserProfileSideBar 
          user={selectedUser} 
          closeSidebar={closeSearchedUserProfileSidebar} 
        />
      )}

    </>
  );
}
