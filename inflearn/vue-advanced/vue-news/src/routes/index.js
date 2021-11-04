import VueRouter from 'vue-router'
import Vue from 'vue'

import NewsView from '@/views/NewsView'
import AskViews from '@/views/AskViews'
import JobsView from '@/views/JobsView'
import UserView from '@/views/UserView'
import ItemView from '@/views/ItemView'

Vue.use(VueRouter)

export const router = new VueRouter({
  mode: 'history',
  /*
  * routes:
  *   path: url 주소
  *   component: url 주소에 해당되는 component
  * */
  routes: [
    {
      path: '/',
      redirect: '/news'
    },
    {
      path: '/news',
      name: 'news',
      component: NewsView
    },
    {
      path: '/ask',
      name: 'ask',
      component: AskViews
    },
    {
      path: '/jobs',
      name: 'jobs',
      component: JobsView
    },
    {
      path: '/user/:id',
      component: UserView
    },
    {
      path: '/item/:id',
      component: ItemView
    },
  ]
})