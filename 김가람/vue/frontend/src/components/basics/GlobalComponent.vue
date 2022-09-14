<template>
  <!-- v-on:click === @click 둘 사이에 차이점은 없음 편한거 사용-->
  <button @click="addCounter">{{ counterValue }}</button>
</template>

<script>
export default {
  name: "GlobalComponent",
  // 헝가리안 표기법??? -> 초기 소문자 이후로 이니셜마다 대문자
  // 이런 형태가 vue와 연결 시 initial-test로 표기
  // props는 상위 컴포넌트에서 전달받은 정보를 저장하기 위해 사용함
  props: ['initialTest'],
  data () {
    return {
      counterValue: this.initialTest
    }
  },
  methods: {
    addCounter () {
      this.counterValue += 1
    }
  }
}
</script>

<style scoped>

</style>