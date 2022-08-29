import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

new Vue({
  router,    //  경로 설정(/) -> 스프링에서의 컨트롤러 역할
  store,     // 스프링이 전해준 데이터를 저장
  render: h => h(App)          // 화면을 그리는 것
}).$mount('#app')

//main.js 파일
//우리가 사용할 Vue 인스턴스를 생성하고 그 안에 router, store 그리고 랜더링 할 vue를 설정합니다.
// 새로운 라이브러리를 설정할 때 해당 파일에 연결해서 사용합니다.