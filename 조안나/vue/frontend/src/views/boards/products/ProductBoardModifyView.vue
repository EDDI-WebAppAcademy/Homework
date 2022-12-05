<template>
  <div align="center">
    <h2>등록 상품 수정</h2>
    <product-board-modify-form v-if="product" :product="product" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>

<script>

import ProductBoardModifyForm from "@/components/boards/products/ProductBoardModifyForm";
import {mapActions, mapState} from "vuex";

export default {
  name: "ProductBoardModifyView",
  components: {ProductBoardModifyForm},
  props: {
    productNo: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions([
      'requestProductBoardFromSpring',
      'requestProductBoardModifyToSpring'
    ]),
    async onSubmit (payload) {
      const { title, content, writer, regDate, image, category, price } = payload
      const productNo = this.productNo

      await this.requestProductBoardModifyToSpring({productNo, title, content, writer, regDate, image, category, price})
      await this.$router.push({
        name: 'ProductBoardReadView',
        params: { productNo: this.productNo }
      })
    }
  },
  created () {
    this.requestProductBoardFromSpring(this.productNo)
  }
}
</script>

<style scoped>
</style>