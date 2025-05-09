// src/Settings.js
import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';

function Settings() {
  const { theme, setTheme } = useContext(ThemeContext);

  return (
    <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
      Toggle Theme (Current: {theme})
    </button>
  );
}

export default Settings;
