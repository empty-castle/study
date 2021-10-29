<template>
  <div>
    <p v-for="job in fetchedJobs" :key="job.id">
      <a :href="job.url">{{ job.title }}</a>
      <small>{{ job.time_ago }} by {{ job.user }}</small>
    </p>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'JobsView',
  computed: {
    ...mapGetters(['fetchedJobs'])
  },
  created() {
    this.$store.dispatch('FETCH_JOBS');
  }
};
</script>

<style scoped>

</style>