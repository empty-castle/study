import React, {Component} from 'react';
import './App.css';
import PhoneFrom from './components/PhoneForm'
import PhoneInfoList from './components/PhoneInfoList'

class App extends Component {

    id = 2
    state = {
        information: [
            {
                id: 0,
                name: '김민준',
                phone: '010-1234-1234'
            },
            {
                id: 1,
                name: '홍길동',
                phone: '010-5678-5678'
            }
        ],
        keyword: ''
    }

    handleChange = (e) => {
        this.setState({
            keyword: e.target.value
        })
    }

    handleCreate = (data) => {
        const {information} = this.state
        this.setState({
            // state 의 불변성을 유지하기 위해 push, splice, unshift, pop 같이 내부의 값을 직접적으로 수정하는 것은 적합하지 않다.
            // 대신 concat, slice, map, filter 와 같은 함수를 이용하여 배열을 다루자
            information: information.concat({id: this.id++, ...data})
        })
    }

    handleRemove = (id) => {
        const {information} = this.state
        this.setState({
            information: information.filter(info => info.id !== id)
        })
    }

    handleUpdate = (id, data) => {
        const {information} = this.state
        this.setState({
            information: information.map(
                info => id === info.id
                ? {...info, ...data} // 새 객체를 만들고 기존의 값 위에 전달받은 data 를 덮자
                : info // 기존의 값은 그대로 유지
            )
        })
    }

    render() {
        const {information, keyword} = this.state
        const filteredList = information.filter(
            info => info.name.indexOf(keyword) !== -1
        )
        return (
            <div>
              <PhoneFrom onCreate={this.handleCreate} />
              <p>
                  <input placeholder={'검색 할 이름을 입력하세요.'} onChange={this.handleChange} value={keyword}/>
              </p>
                <hr/>
              <PhoneInfoList data={filteredList} onRemove={this.handleRemove} onUpdate={this.handleUpdate} />
            </div>
        )
    }
}

export default App;
