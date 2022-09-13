<template>
  <button @click="addCounter">{{ counterValue }}</button>
</template>

<script>
export default {
  name: "global-component",
  props: ['initialTest'],
  data() {
    return {
      counterValue: this.initialTest
    }
  },
  methods: {
    addCounter() {
      this.counterValue += 1
    }
  }
}
</script>

<style scoped>

</style>