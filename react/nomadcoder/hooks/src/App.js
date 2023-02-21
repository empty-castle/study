import useAxios from './hooks/useAxios';

function App() {
  const {loading, data, error, refetch} = useAxios({url: "https://api.coinpaprika.com/v1/tickers"})
  console.log(`Loading: ${loading}\nError: ${error}\nData: ${JSON.stringify(data)}`)
  return (
    <div className="App">
      <h1>hello</h1>
      <h2>{loading && "Loading"}</h2>
      <button onClick={refetch}>Refetch</button>
    </div>
  );
}

export default App;
