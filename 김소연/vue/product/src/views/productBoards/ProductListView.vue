<template>
  <div id="product">
    <h2>상품 리스트</h2>
    <router-link :to="{ name: 'ProductRegisterView' }">
      상품 등록
    </router-link>
    <product-list :products="products"/>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import ProductList from "@/components/productBoards/ProductList";

export default {
  name: "ProductListView.vue",
  components: {
    ProductList
  },
  computed: {
    ...mapState([
      'products'
    ]),
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