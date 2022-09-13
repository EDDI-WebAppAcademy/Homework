
<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring">눌러봐!</button>
    <p>{{ returnValue }}</p>


  </div>
</template>



<script>

import {mapActions } from 'vuex' //VueToSpringView 실제 화면에서 보여지는 화면 컨드롤

export default {
  name: "VueToSpringView",
  data() {
    return {
      returnValue: 0,
    }

  },

  methods: {
    ...mapActions(['requestDataFromSpring']),
    async callRequestDataFromSpring() {
      await this.requestDataFromSpring()
      this.returnValue = this.$store.state.springFromVueTestValue
    }
  },

}





</script>

<style scoped>

</style>