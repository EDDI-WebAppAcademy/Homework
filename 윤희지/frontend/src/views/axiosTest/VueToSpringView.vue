<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring">눌러봐!</button>
    <p>{{ returnValue }}</p>
  </div>

</template>

<script>

import { mapActions } from 'vuex'

export default {
  name: "VueToSpringView",
  data () {
    return {
      returnValue: 0
    }
  },
  methods : {
    ...mapActions(['requestDataFromSpring']),
    // async 밑에 await이 있으면 await 붙은 것 처리하기 전까지 다음거 처리 안함..
    // 쓰레드ㅎㅎ..먼소리노...ㅠㅠ...
    async callRequestDataFromSpring () {
      await this.requestDataFromSpring()
      // 액션에 매핑한 거를 state에 잇는 애를 세팅한다고?
      this.returnValue = this.$store.state.springFromVueTestValue
    }
  }
}
</script>

<style scoped>

</style>