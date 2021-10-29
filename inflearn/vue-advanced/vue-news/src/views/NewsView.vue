<template>
  <div>
    <p :key="item.id" v-for="item in fetchedNews">
      <a :href="item.url">{{ item.title }}</a>
      <small>{{ item.time_ago }} by {{ item.domain }}</small>
    </p>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'NewsView',
  computed: {
    ...mapGetters(['fetchedNews'])
  },
  created() {
    this.$store.dispatch('FETCH_NEWS');
  }
};
</script>

<style scoped>

</style>