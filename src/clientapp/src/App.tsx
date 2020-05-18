import React from 'react';
import logo from './logo.svg';
import './App.css';
import {AppProvider} from "./context/AppContext";
import Hello from "./components/Hello";

function App() {
    return (
        <AppProvider>
            <Hello />
        </AppProvider>
    );
}

export default App;
