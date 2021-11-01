import {fetchAskList, fetchCommentItem, fetchJobsList, fetchNewsList, fetchUserInfo} from '@/api';

export default {
  FETCH_NEWS({ commit }) {
    fetchNewsList()
      .then(({data}) => commit('SET_NEWS', data))
      .catch(err => console.log(err))
  },
  FETCH_ASK({ commit }) {
    fetchAskList()
      .then(({data}) => commit('SET_ASK', data))
      .catch(err => console.log(err))
  },
  FETCH_JOBS({ commit }) {
    fetchJobsList()
      .then(({data}) => commit('SET_JOBS', data))
      .catch(err => console.log(err))
  },
  FETCH_USER({ commit }, username) {
    fetchUserInfo(username)
      .then(({ data }) => commit('SET_USER', data))
      .catch(err => console.log(err))
  },
  FETCH_ITEM({ commit }, id) {
    fetchCommentItem(id)
      .then(({ data }) => commit('SET_ITEM', data))
      .catch(err => console.log(err))
  }
}