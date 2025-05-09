// redux-auth-app/Dashboard.js
import React from 'react';
import { useSelector } from 'react-redux';

function Dashboard() {
  const isLoggedIn = useSelector((state) => state.auth.isLoggedIn);

  return (
    <p style={{ marginTop: '1rem' }}>
      Status: <strong>{isLoggedIn ? 'Logged In ✅' : 'Logged Out ❌'}</strong>
    </p>
  );
}

export default Dashboard;
