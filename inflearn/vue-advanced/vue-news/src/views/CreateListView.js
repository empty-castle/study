import ListView from '@/views/ListView';
import Bus from '@/utils/bus';

export default function createListView(componentName) {
  return {
    name: componentName,
    created() {
      Bus.$emit('start:spinner')
      this.$store.dispatch('FETCH_LIST', this.$route.name)
        .then(() => {
          Bus.$emit('end:spinner')
        })
        .catch(err => console.log(err))
    },
    render(createElement) {
      return createElement(ListView);
    }
  }
}