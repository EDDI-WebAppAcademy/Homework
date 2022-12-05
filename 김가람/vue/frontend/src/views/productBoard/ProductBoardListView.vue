<template>
  <div>
    <div align="right">
      <!-- 로그인 시 관리자 아이디로 로그인하여 페이지 이동하고 싶었으나 기능 구현 부족 문제로 버튼 만듦 -->
      <router-link :to="{ name: 'ManagerProductBoardListView' }">관리자 페이지</router-link>
      <p align="right">로그인</p> <!-- 여기 route-link로 변경 예정 -->
    </div>

    <product-board-list-form :products="products"/> <!-- 상품 목록 컴포넌트 -->
  </div>
</template>

<script>

import ProductBoardListForm from "@/components/productBoard/ProductBoardListForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "ProductBoardListView",
  components: {ProductBoardListForm},
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