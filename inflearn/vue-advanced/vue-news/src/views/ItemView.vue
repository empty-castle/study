<template>
  <div>
    <section>
      <div>
        <div>
          사용자 프로필
        </div>
        <div>
          <router-link :to="`/user/${fetchedItem.user}`">
            {{ fetchedItem.user }}
          </router-link>
          <div>
            {{ fetchedItem.time_ago }}
          </div>
        </div>
        <h2>{{ fetchedItem.title }}</h2>
      </div>
    </section>
    <section>

    </section>
    <p>{{ fetchedItem.title }}</p>
    <div>
      {{ fetchedItem.content }}
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'ItemView',
  computed: {
    ...mapGetters(['fetchedItem'])
  },
  created() {
    const id = this.$route.params.id;
    this.$store.dispatch('FETCH_ITEM', id);
  }
}
</script>

<style scoped>

</style>