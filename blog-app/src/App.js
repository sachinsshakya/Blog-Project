import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Base from './components/Base';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import About from './pages/About';
import Signup from './pages/Signup';
import Login from './pages/Login';
import Home from './pages/Home';
import Services from './pages/Services';

function App() {
  return (
   <BrowserRouter>
    <Routes> 
      <Route path='/' element={<Home />}/>
      <Route path='/login' element={<Login />}/>
      <Route path='/signup' element={<Signup />}/>
      <Route path='/about' element={<About />}></Route>
      <Route path='/services' element={<Services />}></Route>
    </Routes>
   </BrowserRouter>
  );
}

export default App;
