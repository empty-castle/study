import React from 'react';
import './style.css';
import axios from 'axios';

function hello() {
    axios({
        method: 'get',
        url: '/api/hello',
    })
        .then(function (response) {
            document.querySelector('.box').innerHTML = response.data;
        })
}

function react() {
    axios({
        method: 'get',
        url: '/api/react',
    })
        .then(function (response) {
            document.querySelector('.box').innerHTML = response.data;
        })
}

const Root = () => {
    return (
        <div>
            <h3 className="title" onClick={hello}>Hello</h3>
            <h3 className="title" onClick={react}>React</h3>
            <div className="box"></div>
        </div>
    );
};

export default Root;