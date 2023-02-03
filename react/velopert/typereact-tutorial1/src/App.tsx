import React from 'react';
import logo from './logo.svg';
import './App.css';
import Greetings from "./Greetings";
import Counter from "./Counter";
import MyForm from "./MyForm";

function App() {
  const onClick = (name: string) => {
    console.log(`${name} says hello`)
  }

  const onSubmit = (form: {name: string; description: string}) => {
    console.log(form)
  }

  return (
    <div className="App">
      <Greetings onClick={onClick} name={'React'} />
      <Counter />
      <MyForm onSubmit={onSubmit} />

      {/*<header className="App-header">*/}
      {/*  <img src={logo} className="App-logo" alt="logo" />*/}
      {/*  <p>*/}
      {/*    Edit <code>src/App.tsx</code> and save to reload.*/}
      {/*  </p>*/}
      {/*  <a*/}
      {/*    className="App-link"*/}
      {/*    href="https://reactjs.org"*/}
      {/*    target="_blank"*/}
      {/*    rel="noopener noreferrer"*/}
      {/*  >*/}
      {/*    Learn React*/}
      {/*  </a>*/}
      {/*</header>*/}
    </div>
  );
}

export default App;
