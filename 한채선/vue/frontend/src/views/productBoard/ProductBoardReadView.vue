<template>
  <div id="productBoardRead">
    <h2>게시글 상세보기</h2>
    <product-board-read v-if="productBoard" :productBoard="productBoard"/>
    <p v-else>Now Loading......</p>
    <button v-if="isAdmin" @click="deleteThisProduct(productNo)">상품 삭제</button>
  </div>
</template>

<script>
import ProductBoardRead from "@/components/productBoard/ProductBoardRead";
import {mapActions, mapState} from "vuex";

export default {
  name: "ProductBoardReadView",
  components: {ProductBoardRead},
  props: {
    productNo: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['productBoard', 'isAdmin'])
  },
  methods: {
    ...mapActions(['requestProductBoardRead', 'requestDeleteThisProductBoardToSpring']),

    async deleteThisProduct(productNo) {
      await this.requestDeleteThisProductBoardToSpring(productNo)
      await this.$router.push({
        name: 'ProductBoardMainView'
      })
    }
  },
  created() {
    this.requestProductBoardRead(this.productNo)
  }
}
</script>

<style scoped>

</style>