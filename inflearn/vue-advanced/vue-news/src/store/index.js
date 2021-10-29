import Vue from 'vue';
import Vuex from 'vuex'

import mutations from '@/store/mutations';
import actions from '@/store/actions';

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    news: [],
    jobs: [],
    ask: []
  },
  getters: {
    fetchedAsk(state) {
      return state.ask
    },
    fetchedJobs(state) {
      return state.jobs
    },
    fetchedNews(state) {
      return state.news
    }
  },
  mutations,
  actions
})