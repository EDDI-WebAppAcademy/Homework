<template>
  <div id="productBoardRead">
    <h2>게시글 상세보기</h2>
    <product-board-read v-if="productBoard" :productBoard="productBoard"/>
    <p v-else>Now Loading......</p>
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
    ...mapState(['productBoard'])
  },
  methods: {
    ...mapActions(['requestProductBoardRead'])
  },
  created() {
    this.requestProductBoardRead(this.productNo)
  }
}
</script>

<style scoped>

</style>