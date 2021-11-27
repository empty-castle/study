<template>
  <div>
    <UserProfile></UserProfile>
  </div>
</template>

<script>
import UserProfile from '@/components/UserProfile';

export default {
  name: 'UserView',
  components: {UserProfile},
  created() {
    const username = this.$route.params.id;
    this.$store.dispatch('FETCH_USER', username);
  },
}
</script>

<style scoped>

</style>