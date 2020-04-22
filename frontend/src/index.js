import React from 'react';
import ReactDOM from 'react-dom';
import './styles/App.css'
import App from './App';
import {createStore, applyMiddleware} from 'redux'
import {Provider} from 'react-redux'
import * as serviceWorker from './serviceWorker'
import rootReducer from './redux/reducer'
import thunk from 'redux-thunk'
import { BrowserRouter } from 'react-router-dom';

const store = createStore(
  rootReducer, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(), applyMiddleware(thunk))




ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
    <App/>
    </BrowserRouter>

  </Provider>,
  document.getElementById('root')
);

