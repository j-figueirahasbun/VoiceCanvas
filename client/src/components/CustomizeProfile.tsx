import React, {useState, ChangeEvent } from "react";
import { Link } from "react-router-dom";
import '../styles.css'
import apiService from "../services/apiService";
import { useNavigate } from "react-router-dom";

const CustomizeProfile: React.FC = () => {
    const [bio, setBio] = useState<string>("");
    const [image, setIMage] = useState<File | null>(null);
    const navigate = useNavigate();

    const handleBioChange = (e: ChangeEvent<HTMLTextAreaElement>) => {
        setBio(e.target.value);
    };

    const handleImageChange = (e: ChangeEvent<HTMLInputElement>) => {
        const file = e.target.files && e.target.files[0];
        if (file) {
            setIMage(file);
        }
    };

    const handleButtonClick = async () => {
        try {
            const username = localStorage.getItem('username')
            const bioUpdateResult = await apiService.handleBioChange(username, bio);
            console.log("Bio updated successfully to: ", bio, " For user:", username, " ", bioUpdateResult);
            // const imageUpdateResult = await apiService.handleImageChange(username, image);
            // console.log("Image updated successfully for user: ", username, " ", imageUpdateResult);
            navigate("/feed");
        } catch (error){
            console.error('Error customizing profile', error);
        }
    };

    return (
        <>
        <div className="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
          <div className="sm:mx-auto sm:w-full sm:max-w-sm">
            <h2 className="mt-6 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Customize Profile</h2>
          </div>
  
          <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
            <div>
              <h3>Update Bio</h3>
              <textarea
                value={bio}
                onChange={handleBioChange}
                maxLength={140}
                className="block w-full rounded-md border-0 py-2 px-3 
                text-gray-900 shadow-sm ring-1 ring-inset 
                ring-gray-300 
                placeholder:text-gray-400 
                focus:ring-2 focus:ring-inset 
                focus:ring-custom-accent sm:text-sm sm:leading-6"
              />
              <p className="text-sm text-gray-500">{140 - bio.length} characters remaining</p>
            </div>
  
            <div className="mt-4">
              <h3>Upload Profile Image</h3>
              <input
                type="file"
                accept="image/*"
                onChange={handleImageChange}
                className="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
              />
            </div>
  
            <div className="mt-6">
              <button
                type="button"
                onClick={handleButtonClick}
                className="flex w-full justify-center rounded-md 
                bg-custom-accent px-3 py-1.5 text-sm font-semibold leading-6
                   text-white shadow-sm hover:bg-custom-accentlight focus-visible:outline 
                   focus-visible:outline-2 focus-visible:outline-offset-2 
                   focus-visible:outline-custom-accent"
              >
                Submit
              </button>
            </div>
  
            <p className="mt-6 text-center text-sm text-gray-500">
              <Link to="/feed">Back to Home</Link>
            </p>
          </div>
        </div>
      </>
    );
};

export default CustomizeProfile;