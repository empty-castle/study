<template>
  <div>
    <div :key="news.id" v-for="news in this.$store.state.news">
      <div>
        {{ news.title }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NewsView',
  data() {
    return  {
    }
  },
  created() {
    this.$store.dispatch('FETCH_NEWS')
  }
}
</script>

<style scoped>

</style>