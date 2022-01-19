import VueRouter from 'vue-router'
import Vue from 'vue'

import NewsView from '@/views/NewsView'
import AskView from '@/views/AskView'
import JobsView from '@/views/JobsView'
import UserView from '@/views/UserView'
import ItemView from '@/views/ItemView'

import CreateListView from '@/views/CreateListView'
import Bus from '@/utils/bus';
import {store} from '@/store';

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
      component: NewsView,
      // component: CreateListView('NewsView')
    },
    {
      path: '/ask',
      name: 'ask',
      // component: AskViews
      component: CreateListView('AskViews')
    },
    {
      path: '/jobs',
      name: 'jobs',
      component: JobsView,
      // component: CreateListView('JobsView')
      beforeEnter: (to, from, next) => {
        Bus.$emit('start:spinner')
        store.dispatch('FETCH_LIST', to.name)
          .then(() => {
            // Bus.$emit('end:spinner')
            next()
          })
          .catch(err => console.log(err))
      }
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