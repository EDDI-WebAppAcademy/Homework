<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring">눌러봐!</button>
    <p>{{ returnValue }}</p>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'   // Vuex는 모든 컴포넌트가 공유할 수 있는 싱글톤 방식의 데이터-> 저장소상태값 공유를 통해 모든 vue 컴포넌트가 사용 가능
/**
 Vuex에는 4가지 속성이 있고, 각 역할은 다음과 같다.

 states: 변수들의 집합
 getters: states의 변수들을 get하는역할을 한다.(사용 안해도 무방)
 mutations: 변수들을 조작하는 함수들의 집합 ,mutations을 호출해 state의 변수들을 조작
 actions: 비동기 처리를 하는 함수들의 집합 ,actions를 통해 비동기 작업(서버에서 데이터를 가져오는 작업 등)을 호출
 */

export default {
  name: "VueToSpringView",
  data () {
    return {
      returnValue: 0,
    }
  },

  /** computed / watch / methods의 차이점
  computed: 종속 대상을 캐싱해서 저장해놓음. -> 대상이 변경되었을 때만 실행함 (시간 효율 높일 수 있음)
   watch: 감시할 데이터를 지정하고 그 데이터가 변경되면 어떤 함수를 실행해라 하는 방식에 사용함
   methods: 캐싱해두지 않고 호출될 때마다 항상 새롭게 계산됨
  **/

  computed: {
    ...mapState(['springFromVueTestValue'])                           //mapState는 state.js에 있는 value값 써줌. -> 이제 보니 computed는 캐싱해두는 속성이기 때문에 state와 같은 상태값 써준것 같다!
  },
  methods: {
    ...mapActions(['requestDataFromSpring']),                         //mapActions는 actions.js에 있는 메소드 써주는 건데 자바로 치면 유틸리티 메소드, 액션에 배치하는 건 다 쓰레드 베이스
    async callRequestDataFromSpring() {                 // 데이터 요청이 응답보다 처리가 무겁기 때문에 async/ await를 통해 응답이 요청처리 기다리도록 만들어줌
      await this.requestDataFromSpring()            //actons에 작성된 메소드     // 처리가 오래걸리는 요청메소드 앞에 await 써줌 -> 즉, requestDataFromSpring() 메소드 실행이 완료되면 그 다음 응답부분인 returnValue 코드 실행
      this.returnValue = this.$store.state.springFromVueTestValue       // 응답되어 스프링에서 결과값 받아오는 부분
    }
  }
}
</script>

<style scoped>
</style>