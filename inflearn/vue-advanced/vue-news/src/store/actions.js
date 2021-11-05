import {fetchAskList, fetchCommentItem, fetchJobsList, fetchNewsList, fetchUserInfo, fetchList} from '@/api';

export default {
  FETCH_NEWS({commit}) {
    fetchNewsList()
      .then(res => {
        commit('SET_NEWS', res.data);
        return res;
      })
      .catch(err => console.log(err));
  },
  FETCH_ASK({commit}) {
    fetchAskList()
      .then(({data}) => commit('SET_ASK', data))
      .catch(err => console.log(err));
  },
  FETCH_JOBS({commit}) {
    fetchJobsList()
      .then(({data}) => commit('SET_JOBS', data))
      .catch(err => console.log(err));
  },
  FETCH_USER({commit}, username) {
    fetchUserInfo(username)
      .then(({data}) => commit('SET_USER', data))
      .catch(err => console.log(err));
  },
  FETCH_ITEM({commit}, id) {
    fetchCommentItem(id)
      .then(({data}) => commit('SET_ITEM', data))
      .catch(err => console.log(err));
  },
  FETCH_LIST({commit}, pageName) {
    fetchList(pageName)
      .then(res => {
        commit('SET_LIST', res.data)
      })
      .catch(err => console.log(err))
  }
};