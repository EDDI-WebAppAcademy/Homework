<template>
  <div id="productBoard">
    <h2> 등록된 판매 중인 상품들 </h2>
    <product-board-list-form :productLists="productBoards"/>
  </div>
</template>

<script>
import ProductBoardListForm from "@/components/productBoards/ProductBoardListForm";
import { mapState , mapActions } from "vuex";
export default {
  name: "ProductBoardListView",
  components: {
    ProductBoardListForm
  },
  computed: {
    ...mapState([
      'productBoards'
    ])
  },
  methods: {
    ...mapActions([
        'requestProductListFromSpring'
    ])
  },
  mounted() {
    this.requestProductListFromSpring()
  },
}
</script>

<style scoped>

</style>