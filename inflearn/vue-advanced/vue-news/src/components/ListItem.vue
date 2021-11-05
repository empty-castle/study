<template>
  <div>
    <ul class="news-list">
      <li :key="item.id" v-for="item in fetchedList" class="post">
        <div class="points">
          {{ item.points || 0 }}
        </div>
        <div>
          <p class="news-title">
            <template v-if="item.domain">
              <a :href="item.url">
                {{ item.title }}
              </a>
            </template>
            <template v-else>
              <router-link :to="`item/${item.id}`">
                {{ item.title }}
              </router-link>
            </template>
          </p>
          <small class="link-text">
            {{ item.time_ago }} by
            <router-link v-if="item.user" :to="`/user/${item.user}`">
              {{ item.user }}
            </router-link>
            <a :href="item.url" v-else>
              {{ item.domain }}
            </a>
          </small>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'ListItem',
  computed: {
    ...mapGetters(['fetchedList']),
    // listItems() {
    //   switch (this.$route.name) {
    //     case 'news':
    //       return this.$store.state.news;
    //     case 'ask':
    //       return this.$store.state.ask;
    //     case 'jobs':
    //       return this.$store.state.jobs;
    //   }
    // }
  },
};
</script>

<style scoped>
.news-list {
  margin: 0;
  padding: 0;
}

.post {
  list-style: none;
  display: flex;
  align-items: center;
  border-bottom: 1px solid #eee;
}

.points {
  width: 80px;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #42b883;
}

.news-title {
  margin: 0;
}

.link-text {
  color: #828282;
}
</style>