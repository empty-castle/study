const storage = {
  fetch() {
    const arr = []
    if (localStorage.length > 0) {
      for (let i = 0; i < localStorage.length; i++) {
        let key = localStorage.key(i)
        if (key !== 'loglevel:webpack-dev-server') {
          arr.push(JSON.parse(localStorage.getItem(key)))
        }
      }
    }
    return arr
  }
}

const state = {
  todoItems: storage.fetch()
}

const getters = {
  storedTodoItems(state) {
    return state.todoItems
  }
}

const mutations = {
  addOneItem(state, newTodoItem) {
    const obj = {
      completed: false,
      item: newTodoItem
    }
    localStorage.setItem(newTodoItem, JSON.stringify(obj))
    state.todoItems.push(obj)
  },
  removeOneItem(state, { todoItem, index }) {
    localStorage.removeItem(todoItem.item)
    state.todoItems.splice(index, 1)
  },
  toggleOneItem(state, { todoItem, index }) {
    state.todoItems[index].completed = !state.todoItems[index].completed
    localStorage.removeItem(todoItem.item)
    localStorage.setItem(todoItem.item, JSON.stringify(todoItem))
  },
  clearAllItem(state) {
    localStorage.clear()
    state.todoItems = []
  }
}

export default {
  state,
  getters,
  mutations
}