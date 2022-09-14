<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>

    <div>
      <!-- v-bind:initial-test === :initial-test -->
      <p>{{ msg }}</p>
      <global-component :initial-test="counter"/>
      <local-component :initial-value="num"/>
      <button v-on:click="plus">클릭해봐!</button><br/><br/>
      <random-monster-component :random-number="mon"/>
      <button v-on:click="makeRandomMonster">랜덤몬스터 생성</button>


    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import GlobalComponent from "@/components/basic/GlobalComponent";
import LocalComponent from "@/components/basic/LocalComponent";
import RandomMonsterComponent from "@/components/basic/RandomMonsterComponent";


Vue.component(GlobalComponent.name, GlobalComponent)


export default {
  name: "ComponentTestView",
  components: {
    RandomMonsterComponent,
    'local-component': LocalComponent,
  },
  data(){
    return {
      counter: 0,
      num: 0,
      msg: 'vue가 이래서 생산성이 높고 트렌디한 것임.',

      mon: 0, //1에서 21까지의 랜덤변수를 생성. 그러나 재사용성 떨어짐.



    }
  },
  methods: {
    plus (){
      this.num++
    },

    makeRandomMonster () {
      this.mon= Math.floor((Math.random()*(20)))
    },

  }
}
</script>

<style scoped>

</style>