<template>
  <div>
    <h3>상품 목록</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">No</th>
        <th align="center" width="250">상품명</th>
        <th align="center" width="130">가격</th>
        <th align="center" width="100">판매자</th>
        <th align="center" width="150">등록일자</th>
      </tr>
      <tr v-if="!goodsBoards || (Array.isArray(goodsBoards) && goodsBoards.length === 0)">
        <td colspan="5">
          현재 등록된 상품이 없습니다.
        </td>
      </tr>
      <tr v-else v-for="goodsBoard in goodsBoards" :key="goodsBoard.boardNo">
        <td align="center">
          {{ goodsBoard.boardNo }}
        </td>
        <td align="left">
          <router-link :to="{ name: 'GoodsBoardReadView',
                              params: { boardNo : goodsBoard.boardNo.toString() }}">
            {{ goodsBoard.goodsName }}
          </router-link>
        </td>
        <td align="right">
          {{ goodsBoard.price }}
        </td>
        <td align="center">
          {{ goodsBoard.seller }}
        </td>
        <td align="left">
          {{ goodsBoard.regDate }}
        </td>
      </tr>
    </table>

  </div>

</template>

<script>
export default {
  name: "GoodsBoardList",
  props: {
    goodsBoards: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>