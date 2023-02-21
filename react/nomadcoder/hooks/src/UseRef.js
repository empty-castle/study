import {useEffect, useRef} from 'react';

const useClick = (onClick) => {
  const element = useRef();
  useEffect(() => {
    if (typeof onClick !== 'function') {
      return;
    }
    const {removeEventListener, addEventListener} = element.current;
    if (element.current) {
      addEventListener('click', onClick);
    }
    return () => {
      removeEventListener('click', onClick);
    };
  }, []);
  return element;
};

function App() {
  const sayHello = () => console.log('say Hello');
  const title = useClick(sayHello);
  return (
    <div className="App">
      <div ref={title}>Hi</div>
    </div>
  );
}

export default App;
