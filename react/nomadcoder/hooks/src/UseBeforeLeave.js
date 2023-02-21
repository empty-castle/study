import {useEffect} from 'react';

const useBeforeLeave = (onBefore) => {
  const handle = (event) => {
    const {clientY} = event
    if (clientY <= 0) {
      onBefore();
    }
  };
  useEffect(() => {
    if (typeof onBefore !== 'function') {
      return;
    }
    document.addEventListener('mouseleave', handle);
    return () => {
      document.removeEventListener('mouseleave', handle);
    };
  }, []);
};

function App() {
  const begForLife = () => console.log('Pls dont leave');
  useBeforeLeave(begForLife);
  return (
    <div className="App">
    </div>
  );
}

export default App;
