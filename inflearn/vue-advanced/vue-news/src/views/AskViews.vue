<template>
  <div>
    <div v-for="ask in fetchedAsk" :key="ask.id">
      {{ ask.title }}
    </div>
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