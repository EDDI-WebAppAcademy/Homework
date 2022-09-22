<template>
  <div>
    <h1>상품 게시판</h1>
    <product-board-user-status/>
    <br>
    <product-board-list :productBoardList="productBoardList"/>
    <router-link v-if="isAdmin" :to=" { name: 'ProductBoardRegisterView'} ">게시글 등록</router-link>
  </div>
</template>

<script>
import ProductBoardList from "@/components/productBoard/ProductBoardList";
import {mapActions, mapState} from "vuex";
import ProductBoardUserStatus from "@/components/productBoard/ProductBoardUserStatus";
export default {
  name: "ProductBoardListView",
  components: { ProductBoardList, ProductBoardUserStatus},
  computed: {
    ...mapState(['productBoardList', 'isAdmin'])
  },
  data() {
    return {
    }
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