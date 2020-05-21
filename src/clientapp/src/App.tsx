import React from 'react';
import logo from './logo.svg';
import './App.css';
import {AppProvider} from "./context/AppContext";
import Hello from "./components/Hello";
import TeachersList from "./components/TeachersList";

const App: React.FC = () => {
    return (
        <AppProvider>
            <Hello />
            <TeachersList />
        </AppProvider>
    );
}

export default App;
