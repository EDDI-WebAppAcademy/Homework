<template>
<div class="boardList">
  <h2>Goods Shop</h2>
  <products-board-list :boards="boards"/>

</div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import ProductsBoardList from "@/components/productsBoard/ProductsBoardList";


export default {
  name: "ProductsBoardListView",
  components: {
    ProductsBoardList
  },
  computed : {
   ...mapState ([
      'boards'
  ])
  },
  mounted() {
    this.requestBoardListFromSpring()
  },
  methods: {
    ...mapActions([
      'requestBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>