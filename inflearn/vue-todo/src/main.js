import Vue from 'vue'
import App from './App.vue'

import { store } from './store/store'

import { library } from "@fortawesome/fontawesome-svg-core";
import { faPlus, faTrashAlt, faCheck, faTimes } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faPlus, faTrashAlt, faCheck, faTimes)

Vue.config.productionTip = false

Vue.component('font-awesome-icon', FontAwesomeIcon)

new Vue({
  render: h => h(App),
  store
}).$mount('#app')
