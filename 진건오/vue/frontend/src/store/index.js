import Vue from 'vue'
import Vuex from 'vuex'

import state from "@/store/state";
import actions from "@/store/actions";
import mutations from "@/store/mutations";
import getters from "@/store/getters";

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters,
})
//스프링에서 보내온 정보를 저장하기 위한 공간