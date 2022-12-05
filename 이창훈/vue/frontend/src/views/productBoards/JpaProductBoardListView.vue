<template>
  <div id="productBoard">
    <h2>등록 상품들</h2>
    <router-link :to="{ name: 'JpaProductBoardRegisterView' }">
      상품 등록
    </router-link>
    <jpa-product-board-list :productBoards="productBoards"/>
  </div>
</template>

<script>
import JpaProductBoardList from "@/components/productBoards/JpaProductBoardList";
import {mapActions, mapState} from "vuex";
export default {
  name: "JpaProductBoardListView",
  components: {
    JpaProductBoardList,
  },
  computed: {
    ...mapState([
      'productBoards'
    ])
  },
  mounted() {
    this.requestProductBoardListFromSpring()
  },
  methods: {
    ...mapActions([
      'requestProductBoardListFromSpring'
    ])
  },
}
</script>

<style scoped>

</style>