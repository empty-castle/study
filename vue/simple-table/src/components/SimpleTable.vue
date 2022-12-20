<script setup>
import {h, useAttrs, useSlots} from 'vue';

const props = defineProps({
  dataSource: {
    Type: Array,
    required: true,
  },
})

const slots = useSlots()
const attrs = useAttrs()

console.log('slots', slots);
console.log('attrs', attrs);

// import {h} from 'vue';
//
// const render = () => {
//   return h('div', []);
// };
//
// const jsxNode = () => {
//   return <div> text </div>;
// };

</script>

<template>

<!--  <render/>-->
<!--  <jsxNode/>-->

</template>

<style scoped>

</style>