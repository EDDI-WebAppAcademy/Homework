<template>
  <div>
    <h3 align="center">판매 상품</h3>
    <table border="1" align="center">
      <tr>
        <td align="center" width="250">상품명</td>
        <td align="center" width="150">금액</td>
      </tr>
      <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
        <td align="center" colspan="2">
          등록된 상품이 없습니다.
        </td>
      </tr>
      <tr v-else v-for="product in products" :key="product.productNo">
        <td align="center">
          <!-- 상품명을 누르면 상품 상세페이지로 이동할 수 있게 router link 필요 -->
          {{ product.name }}
        </td>
        <td align="center">
          {{ product.price }}
        </td>
      </tr>
    </table>
  </div>

</template>

<script>
export default {
  name: "ProductBoardListForm",
  props: {
    products: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>