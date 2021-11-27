<template>
  <ListItem></ListItem>
</template>

<script>
import ListItem from '@/components/ListItem';
import ListMixin from '@/mixins/ListMixin';
// import Bus from '@/utils/bus';

export default {
  name: 'NewsView',
  components: {
    ListItem
  },
  mixins: [ListMixin]
  // created() {
  //   Bus.$emit('start:spinner')
  //   this.$store.dispatch('FETCH_NEWS')
  //     .then(() => {
  //       Bus.$emit('end:spinner')
  //     })
  //     .catch(err => console.log(err))
  // }
};
</script>

<style scoped>
</style>