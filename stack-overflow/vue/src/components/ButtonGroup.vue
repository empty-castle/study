<script>
import {h} from 'vue';

export default {
  name: 'ButtonGroup',
  render() {
    const buttons = []
    for (let defaultElement of this.$slots.default()) {
      // case: <button />
      if (defaultElement.type === 'button') {
        buttons.push(defaultElement)
      }

      // other component
      // if (defaultElement.type.name === 'Button') {
      //   buttons.push(defaultElement)
      // }
    }
    return h('div', {class: 'button-group'}, buttons)
  }
};
</script>

<style scoped>

</style>