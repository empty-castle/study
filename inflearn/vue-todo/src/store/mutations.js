const addOneItem = (state, newTodoItem) => {
  const obj = {
    completed: false,
    item: newTodoItem
  }
  localStorage.setItem(newTodoItem, JSON.stringify(obj))
  state.todoItems.push(obj)
}

const removeOneItem = (state, { todoItem, index }) => {
  localStorage.removeItem(todoItem.item)
  state.todoItems.splice(index, 1)
}

const toggleOneItem = (state, { todoItem, index }) => {
  state.todoItems[index].completed = !state.todoItems[index].completed
  localStorage.removeItem(todoItem.item)
  localStorage.setItem(todoItem.item, JSON.stringify(todoItem))
}

const clearAllItem = (state) => {
  localStorage.clear()
  state.todoItems = []
}

export { addOneItem, removeOneItem, toggleOneItem, clearAllItem }