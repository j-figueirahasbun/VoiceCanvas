import React, { useState } from "react";
import apiService from '../services/apiService';
import '../App.css';
import { Link, useNavigate } from "react-router-dom";
import '../styles.css';

const SignUp: React.FC = () => {
  const [username, setUsername] = useState<string>("");
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const navigate = useNavigate();

    const handleButtonClick = async () => {
        try {
            const userData = await apiService.handleSignUp(username, email, password);
            console.log('Sign up successful', userData);
            navigate("/");
        } catch (error){
            console.error('Error signing up:', error)
        }
    }

    return (
        <div className="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
          <div className="sm:mx-auto sm:w-full sm:max-w-sm">
            <img className="mt-1 mx-auto h-10 w-auto" src="/audiorecorder_103216.svg" alt="Your Company" />
            <h2 className="mt-6 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Sign Up</h2>
          </div>
    
          <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
            <div>
              <h3>Username</h3>
              <input
                type="text"
                placeholder=" "
                value={username}
                onChange={(e) => setUsername(e.target.value)}    
                className="block w-full rounded-md border-0 py-1.5 px-2 
                text-gray-900 shadow-sm ring-1 ring-inset 
                ring-gray-300 
                placeholder:text-gray-400 
                focus:ring-2 focus:ring-inset 
                focus:ring-custom-accent sm:text-sm sm:leading-6"
              />
            </div>
    
            <div className="mt-4">
              <h3>Email Address</h3>
              <input
                type="text"
                placeholder=""
                value={email}
                onChange={(e) => setEmail(e.target.value)}    
                className="block w-full rounded-md border-0 py-1.5 px-2 
                text-gray-900 shadow-sm ring-1 ring-inset 
                ring-gray-300 
                placeholder:text-gray-400 
                focus:ring-2 focus:ring-inset 
                focus:ring-custom-accent sm:text-sm sm:leading-6"
              />
            </div>
    
            <div className="mt-4">
              <h3>Password</h3>
              <input
                type="password"
                placeholder=""
                value={password}
                onChange={(e) => setPassword(e.target.value)}   
                className="block w-full rounded-md border-0 py-1.5 px-2
                 text-gray-900 shadow-sm ring-1 ring-inset 
                 ring-gray-300 placeholder:text-gray-400 focus:ring-2 
                 focus:ring-inset focus:ring-custom-accent sm:text-sm sm:leading-6"
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
                Sign up
              </button>
            </div>
    
            <p className="mt-6 text-center text-sm text-gray-500">
              Already have an account? <Link to="/" className="font-semibold leading-6 text-custom-accent hover:text-custom-accentlight">Log in</Link>
            </p>
          </div>
        </div>
      );
    };
    
    export default SignUp;