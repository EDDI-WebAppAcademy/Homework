<template>
  <div align="center">
    <h2>상품 정보 수정</h2>
    <product-board-modify-form v-if="productBoard" :productBoard="productBoard" @submit="onSubmit"/>
    <p v-else>Loading ......</p>
  </div>
</template>

<script>
import ProductBoardModifyForm from "@/components/productBoard/ProductBoardModifyForm";
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
    ...mapState(['productBoard'])
  },
  methods: {
    ...mapActions(['requestProductBoardRead', 'requestModifyProductBoardToSpring']),

    async onSubmit(payload) {
      const { regDate, productName, price, content } = payload
      const productNo = this.productNo

      await this.requestModifyProductBoardToSpring({ productNo, regDate, productName, price, content })
      await this.$router.push({
        name: 'ProductBoardReadView',
        params: { productNo: this.productNo }
          }
      )
    }
  },
  created() {
    this.requestProductBoardRead(this.productNo)
  }
}
</script>

<style scoped>

</style>