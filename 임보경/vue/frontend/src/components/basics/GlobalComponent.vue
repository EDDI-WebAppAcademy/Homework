<template>
  <button @click="addCounter"> {{ counterValue }} </button>
</template>

<script>
export default {
  name: "global-component",
  // 헝가리언 표기법 > 초기 소문자 이후로 이니셜마다 대문자
  props : ['initialTest'],
  data () {
    return {
      counterValue : this.initialTest,
    }
  },
  methods : {
    addCounter() {
      this.counterValue += 1
    }
  }
}
</script>

<style scoped>

</style>