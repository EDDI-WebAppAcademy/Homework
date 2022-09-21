<template>
  <div id="ecommerce" align="center">
    <h2>🛒E-Commerce🛒</h2>
    <h3>목적에 맞게 선택해주세요.</h3>
    <button @click="clickToConsumerPage">고객 전용</button> |
    <button @click="clickToSellerPage">판매자 전용</button>
  </div>
</template>

<script>
export default {
  name: "EcommerceBoardView",

  methods:{
    async clickToConsumerPage() {
      await this.$router.push({name: 'EcommerceConsumerListView' })
    },

    async clickToSellerPage() {
      await this.$router.push({name: 'EcommerceSellerListView'})
    },
  }
}
</script>

<style scoped>

</style>