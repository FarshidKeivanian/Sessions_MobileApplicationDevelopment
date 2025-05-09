// src/App.js
import React, { useState } from 'react';
import { ThemeContext } from './ThemeContext';
import Settings from './Settings';
import Dashboard from './Dashboard';

function App() {
  const [theme, setTheme] = useState("light");

  return (
    <ThemeContext.Provider value={{ theme, setTheme }}>
      <div style={{ background: theme === 'dark' ? '#333' : '#fff', color: theme === 'dark' ? '#fff' : '#000', minHeight: '100vh' }}>
        <h1>Student Theme App</h1>
        <Settings />
        <Dashboard />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
