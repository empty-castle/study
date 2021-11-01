<template>
  <div>
    <p>name : {{ fetchedUser.id }}</p>
    <p>karma : {{ fetchedUser.karma }}</p>
    <p>created : {{ fetchedUser.created }}</p>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'UserView',
  computed: {
    ...mapGetters(['fetchedUser'])
  },
  created() {
    const username = this.$route.params.id;
    this.$store.dispatch('FETCH_USER', username);
  },
}
</script>

<style scoped>

</style>