import {useState} from 'react';

function App() {
  const [item, setItem] = useState(1)
  const incrementItem = () => setItem(item + 1)
  const decrementItem = () => setItem(item - 1)
  return (
    <div className="App">
      <h1>{item}</h1>
      <button onClick={incrementItem}>Increment</button>
      <button onClick={decrementItem}>Decrement</button>
    </div>
  );
}

export default App;
