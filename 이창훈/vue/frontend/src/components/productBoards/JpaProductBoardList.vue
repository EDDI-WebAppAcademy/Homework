<template>
  <div>
    <h3>상품 목록</h3>
    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="400">상품명</th>
        <th align="center" width="200">상품가격</th>
        <th align="center" width="240">등록일자</th>
        <th align="center" width="240">판매자</th>
      </tr>
      <tr v-if="!productBoards || (Array.isArray(productBoards) && productBoards.length === 0)">
        <td colspan="5">
          현재 등록된 상품이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="productBoard in productBoards" :key="productBoard.productNo">
        <td align="center">
          {{ productBoard.productNo }}
        </td>
        <td align="left">
          {{ productBoard.productName }}
        </td>
        <td align="center">
          {{ productBoard.price }}
        </td>
        <td align="center">
          {{ productBoard.regDate }}
        </td>
        <td align="center">
          {{ productBoard.seller }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaProductBoardList",
  props: {
    productBoards :{
      type : Array
    }
  }
}
</script>

<style scoped>

</style>