<template>
  <div>
    <h3>상품 목록</h3>
    <table style border ="1" >
      <tr>
        <th align="center" width="50">No</th>
        <th align="center" width="100">이미지</th>
        <th align="center" width="200">상품명</th>
        <th align="center" width="100">카테고리</th>
        <th align="center" width="100">가격</th>
      </tr>
      <tbody>
      <tr v-if="!productBoards || (Array.isArray(productBoards) && productBoards.length === 0)">
        <td colspan="5" align="center">
          현재 등록된 상품이 없습니다! 상품을 등록해주세요.
        </td>
      </tr>
      <tr v-else v-for="product in productBoards" :key="product.boardNo">
        <td align="center">
          {{ product.boardNo }}
        </td>
        <!--이미지 클릭하면 링크 들어가지도록 설정-->
        <td align="center">
          <router-link :to="{ name: 'ProductBoardReadView',
                              params: { productNo: product.productNo.toString() }}">
            {{ product.image }}
          </router-link>
        </td>
        <td align="left">
          <!--제목 클릭하면 링크 들어가지도록 설정-->
          <router-link :to="{ name: 'ProductBoardReadView',
                              params: { productNo: product.productNo.toString() }}">
            {{ product.title }}
          </router-link>
        </td>
        <td align="right">
          {{ product.category }}
        </td>
        <td align="right">
          {{ product.price }}
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "ProductBoardList",
  props: {
    productBoards: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>