import {useInput} from './hooks/useInput';

function App() {
  const maxLen = value => value.length <= 10
  const name = useInput("Mr.", maxLen)
  return (
    <div className="App">
      <h1>Hello</h1>
      <input placeholder={"Name"} {...name} />
    </div>
  );
}

export default App;