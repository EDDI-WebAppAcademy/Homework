<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring">눌러봐!</button>
    <p>{{ returnValue }}</p>
  </div>
</template>

<script>
import { mapActions} from 'vuex'

export default {
  name: "VueToSpringView",
  data() {
    return {
      returnValue: 0,
    }
  },
  methods: {
    ...mapActions(['requestDataFromSpring']), //action을 행당 컴포넌트에서 맵핑해 사용할 수 있게 해줌,액션에 배치된 애들은 다 쓰레드 베이스
    async callRequestDataFromSpring() {
      await this.requestDataFromSpring() //await: 이게 끝나기 전까지 밑에 내용을 실행하지 않는다. 기술면접 빈출 내용
      this.returnValue = this.$store.state.springFromVueTestValue //스토어의 결과를 리턴값에 세팅
    }
  }
}
</script>

<style scoped>
</style>