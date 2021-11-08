import {fetchAskList, fetchCommentItem, fetchJobsList, fetchNewsList, fetchUserInfo, fetchList} from '@/api';

export default {
  async FETCH_NEWS({commit}) {
    try {
      const res = await fetchNewsList();
      commit('SET_NEWS', res.data);
      return res;
    } catch (e) {
      console.log(e)
    }
  },
  async FETCH_ASK({commit}) {
    try {
      const res = await fetchAskList();
      commit('SET_ASK', res.data)
      return res;
    } catch (e) {
      console.log(e)
    }
  },
  FETCH_JOBS({commit}) {
    return fetchJobsList()
      .then(({data}) => commit('SET_JOBS', data))
      .catch(err => console.log(err));
  },
  FETCH_USER({commit}, username) {
    return fetchUserInfo(username)
      .then(({data}) => commit('SET_USER', data))
      .catch(err => console.log(err));
  },
  FETCH_ITEM({commit}, id) {
    return fetchCommentItem(id)
      .then(({data}) => commit('SET_ITEM', data))
      .catch(err => console.log(err));
  },
  FETCH_LIST({commit}, pageName) {
    return fetchList(pageName)
      .then(res => {
        commit('SET_LIST', res.data)
      })
      .catch(err => console.log(err))
  }
};