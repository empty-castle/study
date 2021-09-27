<template>
  <div id="app">
    <TodoHeader></TodoHeader>
<!--    <TodoInput v-on:addTodoItem="addOneItem"></TodoInput>-->
    <TodoInput></TodoInput>
<!--    <TodoList v-bind:todoItems="todoItems"-->
<!--              v-on:removeItem="removeOneItem"-->
<!--              v-on:toggleItem="toggleOneItem"-->
<!--    >-->
<!--    <TodoList v-bind:todoItems="todoItems">-->
    <TodoList>
    </TodoList>
<!--    <TodoFooter v-on:clearAll="clearAllItem">-->
    <TodoFooter>
    </TodoFooter>
  </div>
</template>

<script>
import TodoHeader from "@/components/TodoHeader";
import TodoInput from "@/components/TodoInput";
import TodoList from "@/components/TodoList";
import TodoFooter from "@/components/TodoFooter";

export default {
  name: 'App',
  components: { TodoHeader, TodoInput, TodoList, TodoFooter },
  // data() {
  //   return {
  //     todoItems: []
  //   }
  // },
  // methods: {
    // addOneItem(newTodoItem) {
    //   const obj = {
    //     completed: false,
    //     item: newTodoItem
    //   }
    //   localStorage.setItem(newTodoItem, JSON.stringify(obj))
    //   this.todoItems.push(obj)
    // },
    // removeOneItem(todoItem, index) {
    //   localStorage.removeItem(todoItem.item)
    //   this.todoItems.splice(index, 1)
    // },
    // toggleOneItem(todoItem, index) {
    //   this.todoItems[index].completed = !this.todoItems[index].completed
    //   localStorage.removeItem(todoItem.item)
    //   localStorage.setItem(todoItem.item, JSON.stringify(todoItem))
    // },
    // clearAllItem() {
    //   localStorage.clear()
    //   this.todoItems = []
    // }
  // },
  // created() {
  //   if (localStorage.length > 0) {
  //     for (let i = 0; i < localStorage.length; i++) {
  //       let key = localStorage.key(i)
  //       if (key !== 'loglevel:webpack-dev-server') {
  //         this.todoItems.push(JSON.parse(localStorage.getItem(key)))
  //       }
  //     }
  //   }
  // },
}
</script>

<style>
  body {
    text-align: center;
    background-color: #F6F6F6;
  }
  input {
    border-style: groove;
    width: 200px;
  }
  button {
    border-style: groove;
  }
  .shadow {
    box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
  }
</style>
