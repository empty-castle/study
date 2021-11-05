<template>
  <ListItem></ListItem>
</template>

<script>
import ListItem from '@/components/ListItem';
import Bus from '@/utils/bus';

export default {
  name: 'JobsView',
  components: {
    ListItem
  },
  mounted() {
    Bus.$emit('end:spinner')
  }
  // created() {
  //   Bus.$emit('start:spinner')
  //   this.$store.dispatch('FETCH_JOBS')
  //     .then(() => {
  //       Bus.$emit('end:spinner')
  //     })
  //     .catch(err => console.log(err))
  // }
};
</script>

<style scoped>
</style>