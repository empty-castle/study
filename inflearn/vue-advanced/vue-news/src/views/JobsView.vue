<template>
  <div>
    <div v-for="jobs in jobsList" :key="jobs.id">
      {{ jobs.title }}
    </div>
  </div>
</template>

<script>
import { fetchJobsList } from '../api/index'

export default {
  name: 'JobsView',
  data() {
    return {
      jobsList: []
    }
  },
  created() {
    fetchJobsList()
      .then(res => this.jobsList = res.data)
      .catch(err => console.log(err))
  }
}
</script>

<style scoped>

</style>