<template>
  <div align="center">
    <h2>상품 등록</h2>
    <product-board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import {mapActions} from "vuex";
import ProductBoardRegisterForm from "@/components/productBoard/ProductBoardRegisterForm";

export default {
  name: "ProductBoardRegisterView",
  components: {ProductBoardRegisterForm},
  methods: {
    ...mapActions([
        'requestRegisterProductToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestRegisterProductToSpring(payload)
      await this.$router.push({
        name: 'productBoardListView'
      })
      await this.$router.push({
        name: 'ManagerProductBoardListView',
      })
    }
  }
}
</script>

<style scoped>

</style>