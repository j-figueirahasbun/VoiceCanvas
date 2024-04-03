import React from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
//import './App.css';
import Feed from './pages/Feed.tsx';
import LoginPage from './pages/LoginPage.tsx';
import SignUpPage from './pages/SignUpPage.tsx';
import CustomizeProfilePage from './pages/CustomizeProfilePage.tsx';

const App: React.FC = () => {

    return (
      <Router>
        <div>
          <Routes>
            <Route path='/feed' Component = {Feed}/>
            <Route path='/' Component = {LoginPage}/>
            <Route path='/signup' Component = {SignUpPage}/>
            <Route path='/customizeprofile' Component = {CustomizeProfilePage}/>
          </Routes>
        </div>
      </Router> 
    
    );
}

export default App;
