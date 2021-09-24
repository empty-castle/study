<template>
  <div class="inputBox shadow">
    <input type="text"
           v-model="newTodoItem"
           v-on:keyup.enter="addTodo"
    >
    <span class="addContainer"
          v-on:click="addTodo"
    >
      <font-awesome-icon icon="plus" class="addBtn"></font-awesome-icon>
    </span>
    <modal v-if="showModal" @close="showModal = false">
      <!--
        you can use custom content here to overwrite
        default content
      -->
      <h3 slot="header">
        경고!
        <font-awesome-icon icon="times"
                           class="closeModalBtn"
                           @click="showModal = false">
        </font-awesome-icon>
      </h3>
      <h4 slot="body">아무것도 입력하지 않았어요.</h4>
    </modal>
  </div>
</template>

<script>
import Modal from "@/components/common/Modal";

export default {
  name: "TodoInput",
  data() {
    return {
      newTodoItem: "",
      showModal: false
    }
  },
  methods: {
    addTodo() {
      if (this.newTodoItem !== '') {
        // this.$emit('addTodoItem', this.newTodoItem)
        this.$store.commit('addOneItem', this.newTodoItem)
        this.clearInput()
      } else {
        this.showModal = true
      }
    },
    clearInput() {
      this.newTodoItem = ''
    }
  },
  components: { Modal }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
.closeModalBtn {
  color: #42b983;
}
</style>