<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>

    <div>
      <p>{{ msg }}</p>
      <!-- 커스텀 태그 -->
      <!-- v-bind:initial-test === :initial-test / v-bind는 상위 컴포넌트에서 하위 컴포넌트로 전달 -->
      <!-- 전달 받는 곳은 global-component, 전달 받는 데이터는 initial-test -->
      <global-component :initial-test="counter"/>
      <local-component :initial-value="num"/>
      <button v-on:click="plus">클릭해봐!</button>
    </div>
  </div>


</template>

<script>

import Vue from 'vue'
import GlobalComponent from "@/components/basics/GlobalComponent";
import LocalComponent from "@/components/basics/LocalComponent";

// 전역은 Vue에 등록되어 한번 등록되면 어디서든 사용 가능
// 하여 전역으로 사용한다면 App.vue나 Main 파일에 적어놓는 것이 나음
Vue.component(GlobalComponent.name, GlobalComponent)

export default {
  name: "ComponentTestView",
  // 지역은 여기서만 사용 가능
  components: {
    'local-component': LocalComponent
  },
  data () {
    return {
      counter: 0,
      num: 0,
      msg: 'vue가 이래서 생산성이 높고 트렌디한 것임'
    }
  },
  methods: {
   plus () {
     this.num++
   }
  }
}
</script>

<style scoped>

</style>