<template>
  <div align="center">
    <h2>상품 정보 수정</h2>
    <product-modify-form v-if="product" :product="product" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>

<script>
import ProductModifyForm from "@/components/productBoards/ProductModifyForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "ProductModifyView",
  components: {ProductModifyForm},
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
      'requestProductFromSpring',
      'requestModifyProductToSpring'
    ]),
    async onSubmit (payload) {
      const { productName, seller, price, productDescription, regDate } = payload
      const productNo = this.productNo
      await this.requestModifyProductToSpring({ productNo, productName, seller, price, productDescription, regDate })
      await this.$router.push({
        name: 'ProductReadView',
        params: { productNo: this.productNo }
      })
    }
  },
  created () {
    this.requestProductFromSpring(this.productNo)
  }
}
</script>

<style scoped>
</style>