<template>
  <div>
    <h3> 현재 등록된 게시물 </h3>
    <table border="1">
      <tr>
        <th align="center" width="100">NO</th>
        <th align="center" width="250">상품 이름</th>
        <th align="center" width="200">상품 가격</th>
        <th align="center" width="240">등록 날짜</th>
        <th align="center" width="150">판매 등록인</th>
      </tr>
      <tr v-if="!productBoards  || (Array.isArray(productBoards) && productBoards .length === 0)">
        <td colspan="5"> 등록된 상품이 없습니다! </td>
      </tr>
      <tr v-else v-for="product in productBoards " :key="product.productNo">
        <td align="center">
          {{ product.productNo }}
        </td>
        <td align="center"><!-- 내일 여기에 상품을 보는 read 페이지 링크를 걸어야 한다.-->
          {{ product.name }}
        </td>
        <td align="center">
          {{ product.price }}
        </td>
        <td align="center">
          {{ product.regdate }}
        </td>
        <td align="center">
          {{ product.writer }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "ProductBoardListForm",
  props: {
    productBoards :{
      type : Array
    }
  }
}
</script>

<style scoped>

</style>