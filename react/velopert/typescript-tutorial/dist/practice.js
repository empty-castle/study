"use strict";
// basic
const numbers = [1, 2, 34];
const strings = ['a', 'b'];
let color = 'red';
function sum(x, y) {
    return x + y;
}
function returnNothing() {
    console.log('I am just saying hello world');
}
// class Circle implements Shape {
//
//   radius: number;
//
//   constructor(radius: number) {
//     this.radius = radius
//   }
//
//   getArea(): number {
//     return this.radius * this.radius * Math.PI
//   }
// }
//
// class Rectangle implements Shape {
//
//   width: number;
//   height: number;
//
//   constructor(width: number, height: number) {
//     this.width = width;
//     this.height = height;
//   }
//
//   getArea(): number {
//     return this.width * this.height
//   }
// }
//
// const shapes: Shape[] = [new Circle(5), new Rectangle(10, 5)]
//
// shapes.forEach(shape => {
//   console.log(shape.getArea())
// })
// accessor
class Circle {
    constructor(radius) {
        this.radius = radius;
        this.radius = radius;
    }
    getArea() {
        return this.radius * this.radius * Math.PI;
    }
}
class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
        this.width = width;
        this.height = height;
    }
    getArea() {
        return this.width * this.height;
    }
}
const circle = new Circle(5);
const rectangle = new Rectangle(10, 5);
console.log(circle.radius);
// console.log(rectangle.width)
const shapes = [new Circle(5), new Rectangle(10, 5)];
shapes.forEach(shape => {
    console.log(shape.getArea());
});
const person = {
    name: '김사랑',
    age: 20
};
const expert = {
    name: "김개발",
    skills: ['javascript', 'react']
};
const people = [person, expert];
const human = {
    name: '김사람'
};
const studentA = {
    name: '김학생',
    skills: ['photoshop', 'excel']
};
const city = [human, studentA];
const color2 = 'red';
// Generics
function merge(a, b) {
    return Object.assign(Object.assign({}, a), b);
}
function wrap(param) {
    return {
        param
    };
}
const wrapped = wrap(10);
const items = {
    list: ['a', 'b', 'c']
};
// Generics with Class
class Queue {
    constructor() {
        this.list = [];
    }
    get length() {
        return this.list.length;
    }
    enqueue(item) {
        this.list.push(item);
    }
    dequeue() {
        return this.list.shift();
    }
}
const queue = new Queue();
queue.enqueue(0);
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
