import Vue from 'vue'
import Vuex from 'vuex'

// import * as mutations from './mutations'
// import * as getters from './getters'

import todoApp from './modules/todoApp'

Vue.use(Vuex)

// const storage = {
//   fetch() {
//     const arr = []
//     if (localStorage.length > 0) {
//       for (let i = 0; i < localStorage.length; i++) {
//         let key = localStorage.key(i)
//         if (key !== 'loglevel:webpack-dev-server') {
//           arr.push(JSON.parse(localStorage.getItem(key)))
//         }
//       }
//     }
//     return arr
//   }
// }

export const store = new Vuex.Store({
  // state: {
  //   headerText: 'TODO it!',
  //   todoItems: storage.fetch()
  // },
  // getters: {
    // storedTodoItems(state) {
    //   return state.todoItems
    // }
  // },
  // mutations: {
    // addOneItem(state, newTodoItem) {
    //   const obj = {
    //     completed: false,
    //     item: newTodoItem
    //   }
    //   localStorage.setItem(newTodoItem, JSON.stringify(obj))
    //   state.todoItems.push(obj)
    // },
    // removeOneItem(state, { todoItem, index }) {
    //   localStorage.removeItem(todoItem.item)
    //   state.todoItems.splice(index, 1)
    // },
    // toggleOneItem(state, { todoItem, index }) {
    //   state.todoItems[index].completed = !state.todoItems[index].completed
    //   localStorage.removeItem(todoItem.item)
    //   localStorage.setItem(todoItem.item, JSON.stringify(todoItem))
    // },
    // clearAllItem(state) {
    //   localStorage.clear()
    //   state.todoItems = []
    // }
  // }
  // getters,
  // mutations
  modules: {
    todoApp
  }
})