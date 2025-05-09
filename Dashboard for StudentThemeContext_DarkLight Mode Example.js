// src/Dashboard.js
import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';

function Dashboard() {
  const { theme } = useContext(ThemeContext);
  return <p>The theme is now: <strong>{theme}</strong></p>;
}

export default Dashboard;
