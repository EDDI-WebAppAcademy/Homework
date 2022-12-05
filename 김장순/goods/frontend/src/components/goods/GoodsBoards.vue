<template>
  <div>
    <h2>상품게시판</h2>
    <div align="right">
      <router-link to="/goods-register">
        상품 등록
      </router-link>
    </div>

    <table border="1">
      <tr>
        <th width="100px">상품번호</th>
        <th width="640px">상품명</th>
        <th width="150px">상품가격</th>
        <th width="150px">판매자</th>
        <th width="240px">등록날짜</th>
      </tr>
      <tr v-if="!goodsList || (Array.isArray(goodsList) && goodsList.length === 0)">
        <td colspan="5" align="center">
          현재 등록된 상품이 없습니다.
        </td>
      </tr>
      <tr v-else v-for="goodsBoard in goodsList" :key="goodsBoard.goodsNo">
        <td align="center">
          {{ goodsBoard.goodsNo }}
        </td>
        <td align="center">
          <router-link :to="{ name: 'GoodsReadView',
                             params: { goodsNo: goodsBoard.goodsNo.toString()}}">
            {{ goodsBoard.goodsName }}
          </router-link>
        </td>
        <td align="center">
          {{ goodsBoard.price.toLocaleString() }}
        </td>
        <td align="center">
          {{ goodsBoard.seller }}
        </td>
        <td align="center">
          {{ goodsBoard.regDate }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "GoodsBoards",
  props: {
    goodsList: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>