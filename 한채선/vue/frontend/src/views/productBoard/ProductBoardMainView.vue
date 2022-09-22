<template>
  <div>
    <h1>상품 게시판</h1>
    <br>
    <product-board-list :productBoardList="productBoardList"/>
  </div>
</template>

<script>
import ProductBoardList from "@/components/productBoard/ProductBoardList";
import {mapActions, mapState} from "vuex";
export default {
  name: "ProductBoardListView",
  components: { ProductBoardList},
  computed: {
    ...mapState(['productBoardList'])
  },
  methods: {
    ...mapActions(['requestProductBoardList'])
  },
  mounted() {
    this.requestProductBoardList()
  },
}
</script>

<style scoped>

</style>