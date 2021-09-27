<template>
  <div>
    <transition-group name="list" tag="ul">
<!--      <li v-for="(todoItem, index) in todoItems"-->
<!--          v-bind:key="todoItem.item"-->
<!--          class="shadow"-->
<!--      >-->
      <li v-for="(todoItem, index) in this.storedTodoItems"
          v-bind:key="todoItem.item"
          class="shadow"
      >
        <span>
          <font-awesome-icon icon="check"
                             v-on:click="toggleComplete(todoItem, index)"
                             v-bind:class="[{checkBtnCompleted: todoItem.completed}, 'checkBtn']"
          >
          </font-awesome-icon>
        </span>
        <span v-bind:class="{textCompleted: todoItem.completed}">{{ todoItem.item }}</span>
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <font-awesome-icon icon="trash-alt"></font-awesome-icon>
        </span>
      </li>
    </transition-group>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: "TodoList",
  // props: ['todoItems'],
  methods: {
    removeTodo(todoItem, index) {
      // this.$emit('removeItem', todoItem, index)
      this.$store.commit('removeOneItem', { todoItem, index })
    },
    toggleComplete(todoItem, index) {
      // this.$emit('toggleItem', todoItem, index)
      this.$store.commit('toggleOneItem', { todoItem, index })
    },
    computed: {
      // todoItems() {
      //   return this.$store.getters.storedTodoItems
      // },
      ...mapGetters(['storedTodoItems'])
    }
  },
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;

}
.checkBtnCompleted {
  color: #b3adad;
}
.textCompleted {
  text-decoration: line-through;
  color: #b3adad;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}

.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to /* .list-leave-active below version 2.1.8 */ {
  opacity: 0;
  transform: translateY(30px);
}
</style>