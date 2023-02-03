// basic

const numbers: number[] = [1,2,34]

const strings: string[] = ['a', 'b']

let color: 'red' | 'blue' | 'white' = 'red'

function sum(x: number, y: number): number {
  return x + y
}

function returnNothing(): void {
  console.log('I am just saying hello world');
}

// interface

interface Shape {
  getArea(): number;
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

class Circle implements Shape {

  constructor(public radius: number) {
    this.radius = radius
  }

  getArea(): number {
    return this.radius * this.radius * Math.PI
  }
}

class Rectangle implements Shape {

  constructor(private width: number, private readonly height: number) {
    this.width = width;
    this.height = height;
  }

  getArea(): number {
    return this.width * this.height
  }
}

const circle = new Circle(5)
const rectangle = new Rectangle(10, 5)

console.log(circle.radius)
// console.log(rectangle.width)

const shapes: Shape[] = [new Circle(5), new Rectangle(10, 5)]

shapes.forEach(shape => {
  console.log(shape.getArea())
})

// object with interface

interface Person {
  name: string;
  age?: number;
}

interface Developer extends Person{
  skills: string[];
}

const person: Person = {
  name: '김사랑',
  age: 20
}

const expert: Developer = {
  name: "김개발",
  skills: ['javascript', 'react']
}

const people: Person[] = [person, expert]

// Type Alias

type Human = {
  name: string;
  age?: number;
}

type Student = Person & {
  skills: string[]
}

const human: Human = {
  name: '김사람'
}

const studentA: Student = {
  name: '김학생',
  skills: ['photoshop', 'excel']
}

type Society = Human[]
const city: Society = [human, studentA]

type Color = 'red' | 'orange'
const color2: Color = 'red'

// Generics

function merge<Shape, Person>(a: Shape, b: Person): Shape & Person {
  return {
    ...a,
    ...b
  }
}

function wrap<T>(param: T) {
  return {
    param
  }
}

const wrapped = wrap(10)

// Generics with interface

interface Items<T> {
  list: T[];
}

const items: Items<string> = {
  list: ['a', 'b', 'c']
}

// Generics with Class

class Queue<T> {
  list: T[] = [];

  get length() {
    return this.list.length;
  }

  enqueue(item: T) {
    this.list.push(item)
  }

  dequeue() {
    return this.list.shift()
  }
}

const queue = new Queue<number>();
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
