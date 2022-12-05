<template>
  <div align="center">
    <h2>상품 세부 사항 보기</h2>
    <product-read v-if="product" :product="product"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'ProductModifyView', params: { productNo } }">
      상품 정보 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'ProductListView' }">
      돌아가기
    </router-link>
  </div>
</template>

<script>
import ProductRead from "@/components/productBoards/ProductRead";
import {mapActions, mapState} from "vuex";
export default {
  name: "ProductReadView",
  components: {
    ProductRead
  },
  props: {
    productNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions([
      'requestProductFromSpring',
      'requestDeleteProductToSpring',
    ]),
    async onDelete () {
      await this.requestDeleteProductToSpring(this.productNo);
      await this.$router.push({ name: 'JpaProductListView' })
    }
  },
  created() {
    this.requestProductFromSpring(this.productNo)
  }
}
</script>

<style scoped>
</style>