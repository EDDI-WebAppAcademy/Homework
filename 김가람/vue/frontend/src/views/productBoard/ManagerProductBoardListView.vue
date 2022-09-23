<template>
  <div id="product" align="center">
    <manager-product-board-list-form :products="products"/>
    <router-link :to="{ name: 'productBoardRegisterView'}">
      상품 등록
    </router-link>
  </div>
</template>

<script>
import ManagerProductBoardListForm from "@/components/productBoard/ManagerProductBoardListForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "ManagerProductBoardListView",
  components: {ManagerProductBoardListForm},
  computed: {
    ...mapState([
        'products'
    ])
  },
  mounted() {
    this.requestProductListFromSpring()
  },
  methods: {
    ...mapActions([
        'requestProductListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>