<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring" >눌러봐!</button>
    <ul>
      <li v-for="(status, index) in player" :key="index">
        {{ status }}
      </li>
    </ul>
  </div>
</template>

<script>

import { mapActions } from 'vuex'

export default {
  name: "VueToSpringView",
  data() {
    return {
      player: ''
          // mapState > states안의 값을 위의 player 저장
    }
  },
  methods : {
    ...mapActions(['requestDataFromSpring']),
    //actions에 있는 메소드를 가져옴. actions는 유틸리티 메서드
    async callRequestDataFromSpring() {
      // await 된 녀석이 일을 끝날 때까지 async 하지마
      // 쓰레드를 쓰는 이유 : 동시에 여러 일을 처리한다. > 빠르다.
      await this.requestDataFromSpring()
      this.player = this.$store.state.springFromVueTestValue
    },
  }
}
</script>

<style scoped>

</style>