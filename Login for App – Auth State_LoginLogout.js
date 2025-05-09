// redux-auth-app/Login.js
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login, logout } from './authSlice';

function Login() {
  const dispatch = useDispatch();
  const isLoggedIn = useSelector((state) => state.auth.isLoggedIn);

  return (
    <div>
      <button onClick={() => dispatch(login())} disabled={isLoggedIn}>
        Login
      </button>
      <button onClick={() => dispatch(logout())} disabled={!isLoggedIn} style={{ marginLeft: '1rem' }}>
        Logout
      </button>
    </div>
  );
}

export default Login;
