import axios from 'axios'

const config = {
  baseUrl: 'https://api.hnpwa.com/v0'
}

function fetchNewsList() {
  return axios.get(`${config.baseUrl}/news/1.json`)
}

function fetchJobsList() {
  return axios.get(`${config.baseUrl}/jobs/1.json`)
}

async function fetchAskList() {
  try {
    return await axios.get(`${config.baseUrl}/ask/1.json`)
  } catch (e) {
    console.log(e)
  }
}

function fetchUserInfo(username) {
  return axios.get(`${config.baseUrl}/user/${username}.json`)
}

function fetchCommentItem(id) {
  return axios.get(`${config.baseUrl}/item/${id}.json`)
}

function fetchList(pageName) {
  return axios.get(`${config.baseUrl}/${pageName}/1.json`)
}

export {
  fetchNewsList,
  fetchJobsList,
  fetchAskList,
  fetchUserInfo,
  fetchCommentItem,
  fetchList
}