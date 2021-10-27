<template>
  <div>
    <div :key="news.id" v-for="news in newsList">
      <div>
        {{ news.title }}
      </div>
    </div>
  </div>
</template>

<script>
import { fetchNewsList } from '../api/index'

export default {
  name: 'NewsView',
  data() {
    return  {
      newsList: []
    }
  },
  created() {
    fetchNewsList()
      .then(res => this.newsList =  res.data)
      .catch(err => console.log(err))
  }
}
</script>

<style scoped>

</style>