<template>
  <div align="center">
    <h2>상품 정보 수정</h2>
    <jpa-product-board-modify-form v-if="productBoard" :productBoard="productBoard" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>

<script>
import JpaProductBoardModifyForm from "@/components/productBoards/JpaProductBoardModifyForm";
import {mapActions, mapState} from "vuex";

export default {
  name: "JpaProductBoardModifyView",
  components: {
    JpaProductBoardModifyForm
  },
  props: {
    productNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['productBoard'])
  },
  methods: {
    ...mapActions([
        'requestProductBoardFromSpring',
        'requestModifyProductBoardToSpring'
    ]),
    async onSubmit (payload) {
      const { productName, seller, price, regDate, content } = payload
      const productNo = this.productNo
      await this.requestModifyProductBoardToSpring({ productNo, productName, seller, price, regDate, content })
      await this.$router.push({
        name: 'JpaProductBoardReadView',
        params: { productNo: this.productNo }
      })
    }
  },
  created() {
    this.requestProductBoardFromSpring(this.productNo)
  }
}
</script>

<style scoped>

</style>