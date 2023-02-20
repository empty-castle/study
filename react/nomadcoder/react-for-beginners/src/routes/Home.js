import {useEffect, useState} from 'react';

function Home() {
  const [loading, setLoading] = useState(true)
  const [coins, setCoins] = useState([])
  const getCoins = async () => {
    const res = await fetch("https://api.coinpaprika.com/v1/tickers")
    const json = await res.json()
    setCoins(json)
    setLoading(false)
  }
  useEffect(() => {
    getCoins()
  }, [])
  return (
    <div>
      {loading ? <h1>Loading...</h1> :
        <div>
          {coins.map(item => (
            <div key={item.id}>
              <h2>{item.name}</h2>
              <p>{item.symbol}</p>
            </div>
          ))}
        </div>
      }
    </div>
  );
}

export default Home