import {useRef} from 'react';

const useFullscreen = (callback) => {
  const element = useRef();
  const triggerFull = () => {
    if (element.current) {
      element.current.requestFullscreen();
      if (callback && typeof callback === "function") {
        callback(true)
      }
    }
  };
  const exitFull = () => {
    document.exitFullscreen();
    if (callback && typeof callback === "function") {
      callback(false)
    }
  };
  return {element, triggerFull, exitFull};
};

function App() {
  const onFullS = (isFull) => {
    console.log(isFull ? "We are full" : "We are small");
  }
  const {element, triggerFull, exitFull} = useFullscreen(onFullS);
  return (
    <div className="App" style={{height: '1000vh'}}>
      <div ref={element}>
        <img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg"/>
        <button onClick={exitFull}>Exit fullscreen</button>
      </div>
      <button onClick={triggerFull}>Make fullscreen</button>
    </div>
  );
}

export default App;
