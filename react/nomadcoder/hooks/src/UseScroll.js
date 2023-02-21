import {useEffect, useState} from 'react';

const useScroll = () => {
  const [status, setStatus] = useState({
    x: 0,
    y: 0,
  });
  const onScroll = () => {
    console.log(window.scrollY);
    setStatus({y: window.scrollY, x: window.scrollX})
  }
  useEffect(() => {
    window.addEventListener("scroll", onScroll)
    return () => {
      window.removeEventListener("scroll", onScroll)
    }
  }, [])
  return status;
};

function App() {
  const {y} = useScroll();
  return (
    <div className="App" style={{height: "1000vh"}}>
      <h1 style={{position: 'fixed', color: y > 100 ? "red" : "blue"}}>Hello</h1>
    </div>
  );
}

export default App;
