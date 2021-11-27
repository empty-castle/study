<template>
  <div>
    <section>
      <UserProfile :info="fetchedItem">
        <template v-slot:username>
          <router-link :to="`/user/${fetchedItem.user}`">
            {{ fetchedItem.user }}
          </router-link>
        </template>
        <template v-slot:time>
          Posted {{ fetchedItem.time_ago }}
        </template>
      </UserProfile>
    </section>
    <section>
      <h2>{{ fetchedItem.title }}</h2>
    </section>
    <section>
      <div v-html="fetchedItem.content"></div>
    </section>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
import UserProfile from '@/components/UserProfile';

export default {
  name: 'ItemView',
  components: {UserProfile},
  computed: {
    ...mapGetters(['fetchedItem'])
  },
  created() {
    const id = this.$route.params.id;
    this.$store.dispatch('FETCH_ITEM', id);
  }
};
</script>

<style scoped>
.user-container {
  display: flex;
  align-items: center;
  padding: 0.5rem;
}

.fa-user {
  width: 30px;
  font-size: 2.5rem;
}

.user-description {
  padding-left: 8px;
}

.time {
  font-size: 0.7rem;
}
</style>