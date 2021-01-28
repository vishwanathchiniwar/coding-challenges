import { useState, useEffect } from "react";
import './App.css';

function App() {
  const  [helloMessage,setHelloMessage]= useState("")

  useEffect(() =>
      fetch("http://localhost:8080/api/hello")
          .then(res => res.text())
          .then(res => setHelloMessage(res))
  );

  return (
    <div className="App">
      <header className="App-header">
        <p>{helloMessage}</p>
      </header>
    </div>
  );
}

export default App;
