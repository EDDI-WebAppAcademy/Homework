<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>

    <div>
      <!-- v-bind:inital-test === :initial-test -->
      <P>{{ msg }}</P>
      <global-component :initial-test="counter"/>
      <local-component :initial-value="num"/>
      <button v-on:click="plus">클릭해봐!</button>

      <market-manager></market-manager>
      <inventory-component></inventory-component>
      <character-manager-component></character-manager-component>
      <experience-component></experience-component>
      <monster-manager-component></monster-manager-component>

    </div>
  </div>
</template>

<script>

import Vue from 'vue'
import GlobalComponent from "@/components/basics/GlobalComponent";
import LocalComponent from "@/components/basics/LocalComponent";
import MonsterManager from "@/components/basics/MonsterManager";
import CharacterManager from "@/components/basics/CharacterManager";
import Experience from "@/components/basics/Experience";
import InventoryManager from "@/components/basics/InventoryManager";
import MarketManager from "@/components/basics/MarketManager";

Vue.component(GlobalComponent.name, GlobalComponent) //global은 vue자체에 등록해 한번 선언하면 어디서든 사용 가능

export default {
  name: "ComponentTestView",
  components: {
    'local-component': LocalComponent, //local은 이렇게 선언해 놓은 곳에서만 사용가능
    'monster-manager-component': MonsterManager,
    'character-manager-component': CharacterManager,
    'experience-component': Experience,
    'inventory-component': InventoryManager,
    'market-manager': MarketManager
  },
  data() {
    return {
      counter: 0,
      num: 0,
      msg: 'vue가 이래서 생산성이 높고 트렌디한 것임.'
    }
  },
  methods: {
    plus() {
      this.num++
    }
  }
}
</script>

<style scoped>

</style>