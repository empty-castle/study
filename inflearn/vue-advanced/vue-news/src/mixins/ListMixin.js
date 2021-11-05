import Bus from '@/utils/bus';

export default {
  created() {
    Bus.$emit('start:spinner')
    this.$store.dispatch('FETCH_LIST', this.$route.name)
      .then(() => {
        Bus.$emit('end:spinner')
      })
      .catch(err => console.log(err))
  }
}