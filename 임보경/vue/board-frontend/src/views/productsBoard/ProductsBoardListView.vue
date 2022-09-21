<template>
<div class="boardList">
  <h2>Goods Shop</h2>
  <products-board-list/>

</div>
</template>

<script>
import ProductsBoardList from "@/components/productsBoard/ProductsBoardList";

export default {
  name: "ProductsBoardListView",
  components: {
    ProductsBoardList
  },
}
</script>

<style scoped>

</style>