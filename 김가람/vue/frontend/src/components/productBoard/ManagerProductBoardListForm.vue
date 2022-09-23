<template>
  <div>
    <h3 align="center">상품 목록(관리자)</h3>
    <table border="1" align="center">
      <tr>
        <td align="center" width="100">상품번호</td>
        <td align="center" width="250">상품명</td>
      </tr>
      <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
        <td align="center" colspan="2">
          등록된 상품이 없습니다.
        </td>
      </tr>
      <tr v-else v-for="product in products" :key="product.productNo">
        <td align="center">
          {{ product.productNo }}
        </td>
        <td align="center">
          <!-- 상품명을 누르면 상품 상세페이지로 이동할 수 있게 router link 필요 -->
          {{ product.name }}
        </td>
      </tr>
    </table>
  </div>

</template>

<script>
export default {
  name: "ManagerProductBoardListForm",
  props: {
    products: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>