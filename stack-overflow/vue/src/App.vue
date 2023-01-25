<template>
<!--  <FormSubmit/>-->
  <ButtonGroup>
    <button>BUTTON TAG</button>
    <p>P TAG</p>
    <button>BUTTON TAG</button>
    <FormSubmit>BUTTON TAG</FormSubmit>
  </ButtonGroup>
</template>

<script>
import FormSubmit from '@/components/FormSubmit';
import ButtonGroup from '@/components/ButtonGroup';
export default {
  name: 'App',
  components: {ButtonGroup, FormSubmit},
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
