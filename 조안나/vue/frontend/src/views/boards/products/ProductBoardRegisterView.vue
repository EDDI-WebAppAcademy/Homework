<template>
  <div align="center">
    <h2>상품 등록</h2>
    <product-board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import ProductBoardRegisterForm from "@/components/boards/products/ProductBoardRegisterForm";

import {mapActions} from "vuex";
export default {
  name: "ProductBoardRegisterView",
  components: {
    ProductBoardRegisterForm
  },
  methods: {
    ...mapActions([
      'requestCreateProductBoardContentsToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestCreateProductBoardContentsToSpring(payload)
      await this.$router.push({
        name: 'ProductBoardListView'
      })
    }
  }
}
</script>
<style scoped>
</style>