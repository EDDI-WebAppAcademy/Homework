<template>
  <div id="product">
    <h2>Vue + Spring + JPA Product Boards</h2>
    <router-link :to="{ name: 'ProductBoardRegisterView' }">
      상품 등록
    </router-link>
    <product-board-list :productBoards ="productBoards"/>
  </div>
</template>

<script>

import {mapActions, mapState} from "vuex";
import ProductBoardList from "@/components/boards/products/ProductBoardList";

export default {
  name: "ProductBoardReadView",
  components: {
    ProductBoardList,
  },
  computed: {
    ...mapState([
      'productBoards'
    ]),
  },
  mounted() {
    this.requestProductBoardListFromSpring()
  },
  methods: {
    ...mapActions([
      'requestProductBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>