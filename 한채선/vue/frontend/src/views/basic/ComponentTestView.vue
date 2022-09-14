<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>
    <div>
      <global-component :initial-test="counter"/>
      <local-component :initial-value="num"/>
      <button v-on:click="plus">클릭해봐!</button>

    </div>
  </div>


</template>

<script>

import Vue from "vue";

import GlobalComponent from "@/components/basic/GlobalComponent";
import LocalComponent from "@/components/basic/LocalComponent";

Vue.component(GlobalComponent.name, GlobalComponent)

export default {
  name: "ComponentTestView",
  components: {
    'local-component': LocalComponent
  },
  data () {
    return {
      counter: 0,
      num: 0,
      msg: 'vue의 생산성을 확인할 수 있다'
    }
  },
  methods: {
    plus () {
      this.num ++
    }
  }
}
</script>

<style scoped>

</style>