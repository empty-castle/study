<template>
  <ListItem></ListItem>
</template>

<script>
import ListItem from '@/components/ListItem';
import Bus from '@/utils/bus';

export default {
  name: 'AskView',
  components: {ListItem},
  created() {
    Bus.$emit('start:spinner')
    this.$store.dispatch('FETCH_ASK')
      .then(() => {
        Bus.$emit('end:spinner')
      })
      .catch(err => console.log(err))
  }
};
</script>

<style scoped>
</style>