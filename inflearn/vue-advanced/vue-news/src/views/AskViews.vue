<template>
  <div>
    <p v-for="item in fetchedAsk" :key="item.id">
      <router-link :to="`/item/${item.id}`">{{ item.title }}</router-link>
      <small>{{ item.time_ago }} by
        <router-link :to="`/user/${item.user}`">
          {{ item.user }}
        </router-link>
      </small>
    </p>
  </div>
</template>

<script>
import {
  // mapState,
  mapGetters
} from 'vuex'

export default {
  name: 'AskViews',
  computed: {
    ...mapGetters(['fetchedAsk'])
    // ...mapState({
    //   fetchedAsk: state => state.ask
    // })
  },
  created() {
    this.$store.dispatch('FETCH_ASK')
  }
}
</script>

<style scoped>

</style>