<template>
  <div>
    <div v-for="ask in askList" :key="ask.id">
      {{ ask.title }}
    </div>
  </div>
</template>

<script>
import { fetchAskList } from '../api/index'

export default {
  name: 'AskViews',
  data() {
    return {
      askList: []
    }
  },
  created() {
    fetchAskList()
      .then(res => this.askList = res.data)
      .catch(err => console.log(err))
  }
}
</script>

<style scoped>

</style>