<!-- 화면에서 보여지는 걸 컨트롤 하는 것은 여기 -->
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
      returnValue: 0,
    }
  },
  // computed: {
  //   // 실질적으로 여기서 필요하지 않음
  //   // mapState는 state에 접근
  //   ...mapState(['springFromVueTestValue'])
  // },

  methods: {
    // mapActions -> actions에 맵핑하여 메소드 사용
    // 기본적으로 actions에 배치하는 것들은 쓰레드 베이스임.
    // store에 있는 action은 java로 치면 utility라고 볼 수 있음
    ...mapActions(['requestDataFromSpring']),
    // 쓰레드는 다중처리하며 빨리 처리된 것부터 내보냄. 고로 순차적으로 실행된다는 보장이 없다.
    // async 안에 await가 들어있으면 await가 끝날때까지 그 아래의 코드를 실행하지 않음
    async callRequestDataFromSpring () {
      await this.requestDataFromSpring()
      this.returnValue = this.$store.state.springFromVueTestValue
    }
  }
}
</script>

<style scoped>


</style>
