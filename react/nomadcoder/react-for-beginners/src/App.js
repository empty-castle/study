import {useState} from 'react';

function App() {
  const [toDo, setToDo] = useState('');
  const [toDos, setToDos] = useState([]);
  const onChange = (event) => setToDo(event.target.value);
  const onSubmit = (event) => {
    event.preventDefault();
    if (toDo === '') {
      return;
    }
    setToDos(prev => [toDo, ...prev]);
    setToDo('');
  };
  return (
    <div className="App">
      <h1>My To Dos ({toDos.length})</h1>
      <form onSubmit={onSubmit}>
        <input
          type={'text'}
          placeholder={'Write your to do...'}
          value={toDo}
          onChange={onChange}
        />
        <button>Add To Do</button>
        <hr/>
        <ul>
          {toDos.map((item, index) => <li key={index}>{item}</li>)}
        </ul>
      </form>
    </div>
  );
}

export default App;
