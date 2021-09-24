<template>
  <div>
    <app-header
        v-on:renew="renewStr"
        v-bind:propsdata="str"></app-header>
  </div>
</template>

<script>

import AppHeader from "@/components/AppHeader";

export default {
  name: "App",
  components: {
    'app-header': AppHeader
  },
  // components: {AppHeader},
  data: function () {
    return {
      str: `Header`
    }
  },
  methods: {
    renewStr: function () {
      this.str = `Hi`
    }
  }
}
</script>

<style scoped>

</style>