<template>
  <div align="center">
    <h2>상품 페이지</h2>
    <product-board-read v-if="product" :product="product"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'ProductBoardModifyView', params: { productNo } }">
      <button>게시물 수정</button>
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'ProductBoardListView' }">
      <button>돌아가기</button>
    </router-link>
  </div>
</template>

<script>
import ProductBoardRead from "@/components/boards/products/ProductBoardRead";
import {mapActions, mapState} from "vuex";

export default {
  name: "ProductBoardReadView",
  components: {ProductBoardRead},
  props: {
    productNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions([
      'requestProductBoardFromSpring',
      'requestDeleteProductBoardToSpring',
    ]),
    async onDelete () {
      await this.requestDeleteProductBoardToSpring(this.productNo);
      await this.$router.push({ name: 'ProductBoardListView' })
    }
  },
  created() {
    this.requestProductBoardFromSpring(this.productNo)
  }
}
</script>

<style scoped>
</style>