<template>
  <div>
    <div v-for="jobs in this.$store.state.jobs" :key="jobs.id">
      {{ jobs.title }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'JobsView',
  data() {
    return {
      jobsList: []
    }
  },
  created() {
    this.$store.dispatch('FETCH_JOBS')
  }
}
</script>

<style scoped>

</style>