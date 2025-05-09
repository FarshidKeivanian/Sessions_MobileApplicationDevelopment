// redux-auth-app/App.js
import React from 'react';
import { Provider } from 'react-redux';
import { store } from './store';
import Login from './Login';
import Dashboard from './Dashboard';

function App() {
  return (
    <Provider store={store}>
      <div style={{ padding: '2rem', fontFamily: 'Arial' }}>
        <h1>Redux Auth App</h1>
        <Login />
        <Dashboard />
      </div>
    </Provider>
  );
}

export default App;
