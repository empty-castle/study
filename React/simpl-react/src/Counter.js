import React, {Component} from 'react';
// https://velopert.com/3629

const Problematic = () => {
    throw (new Error('버그가 나타났다!'))
    return (
        <div></div>
    )
}

class Counter extends Component {

    // state 를 설정하는 두 가지의 방법, constructor / class fields
    // ==> class fields 가 먼저 생성되고 그 이휴에 constructor 가 설정된다

    constructor(props) {
        super(props)
        console.log('constructor')
    //     this.state = {
    //         number: 0
    //     }
    //     this.increase = this.increase.bind(this);
    //     this.decrease = this.decrease.bind(this);
    }


    componentWillMount() {
        // 컴포넌트가 여러분의 화면에 나타나기 직전에 호출되는 API ==> v16.3부터 deprecated 알아만 두자
        // 해당 API 의 기능은 constructor 와 componentDidMount 두 개로 충분히 처리 할 수 있다
        console.log('componentWillMount/deprecated')
    }

    componentDidMount() {
        // 컴포넌트가 화면에 나타나게 됐을 떄 호출된다. DOM 을 사용하는 외부 라이브러리나 ajax 요청 등을 여기에서
        console.log('componentDidMount')
    }

    componentWillReceiveProps(nextProps, nextContext) {
        // 새로운 props 를 받게 되었을 떄 호출된다. 주로 state 가 props 에 따라 변해야 하는 로직을 작성
        // v16.3 부터 deprecated 되니 알아만 두자 ==> getDerivedStateFromProps 가 v16.3 에서 해당 API 를 대신하게 된다.
        console.log('componentWillReceiveProps/deprecated')
    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        // 부모 컴포넌트가 리렌더링이 된다면 자식 컴포넌트는 무조건 렌더링이 다시 된다.
        // 그러한 현상을 막기 위해 해당 API 를 작성하여 조건에 따라 렌더링 되게 한다.
        console.log('shouldComponentUpdate')
        if (nextState.number % 5 === 0) return false;
        return true;
    }

    componentWillUpdate(nextProps, nextState, nextContext) {
        // shouldComponentUpdate 가 true 를 리턴할 떄만 호출되는 API
        // 주로 애니메이션 효과를 초기화하거나 이벤트 리스너를 없애는 작업을 하게 된다.
        // v16.3 이후로 deprecated ==> getSnapshotBeforeUpdate 가 대체한다
        console.log('componentWillUpdate/deprecated')
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        /*
        * 1. render()
        * 2. getSnapshotBeforeUpdate
        * 3. 실제로 DOM 에 변화 발샐
        * 4. componentDidUpdate
        * 해당 API 가 리턴하는 값은 componentDidUpdate 의 3번쨰 파라미터로 받아올 수 있게 된다.
        * */
        console.log('getSnapshotBeforeUpdate')
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        // 이 시점에서는 props 와 state 가 바뀌어있다.
        console.log('componentDidUpdate')
    }

    componentWillUnmount() {
        // 등록했었던 이벤트를 제거하게 된다.
        console.log('componentWillUnmount')
    }

    componentDidCatch(error, errorInfo) {
        // 에러가 발생하면 호출되는 API
        this.setState({
            error: true
        })
    }

    state = {
        number: 0,
        foo: {
            bar: 0,
            car: 1
        }
    };

    // 함수형 컴포넌트, 화살표 함수의 작성으로 인해 this 가 바라보는 객체가 달라진다

    increase = () => {

        // setState 함수는 호출될때 해당 컴포넌트가 리렌더링 되도록 설계되어 있다.
        // 또한 setState 는 객체의 깊숙한 곳(depth 2 이상)을 확인하지 못한다.

        // this.setState({
        //     number: this.state.number + 1
            // 아래와 같이 setState 를 한다면 state 의 foo: { car: 2 } 가 되어 버린다. car 값이 사라져버린다.
            // ,foo: {
            //     car: 2
            // }
        // })

        // 아래와 같이 코드를 작성한다면 this 를 다시 참조하지 않아도 state 를 가져올 수 있따.
        // setState 의 첫 번째 인자로 state 가 들어온다.
        // this.setState(
        //     (state) => ({
        //         number: state.number
        //     })
        // )

        // 더 나아가 '비구조화 할당' 문법을 사용하요 아래와 같이 작성 할 수 있다.
        this.setState(
            ({number}) => ({
                number: number + 1
            })
        )

        // 위의 비구조화 할당을 이용한다면 아래와 같이 작성도 가능하다.
        // const { number } = this.state;
        // this.setState({
        //     number: number + 1
        // })

    }

    decrease = () => {
        this.setState({
            number: this.state.number - 1
            // 그래서 아래와 같이 전개연산자(...) 를 사용하여 기존의 객체를 뿌려주고 덮어씌우는 식으로 작성해야 한다.
            // ==> 나중에는 immutable.js 사용하여 간단하게 해보자
            // , foo {
            //     ...this.state.foo,
            //     car: 2
            // }
        })
    };

    // 아래와 같이 화살표 함수로 작성하지 않는다면 constructor 에서 this 를 바인딩해야 한다.

    // increase() {
    //     this.setState({
    //         number: this.state.number + 1
    //     })
    // }

    // decrease() {
    //     this.setState({
    //         number: this.state.number - 1
    //     })
    // }

    render() {
        if (this.state.error) return (
            <h1>에러 발생!</h1>
        )
        
        return (
            <div>
                <h1>카운터</h1>
                <div>값: {this.state.number}</div>
                {this.state.number === 4 && <Problematic/>}
                <button onClick={this.increase}>+</button>
                <button onClick={this.decrease}>-</button>
            </div>
        )
    }
}

export default Counter;