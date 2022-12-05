<template>

  <div class="listWrap">
    <h3>상품 리스트</h3>

    <table>
      <tr class="divide">
        <th >Product No</th>
        <th> </th>
        <th>제품명</th>
        <th >제품 가격</th>
      </tr>

      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td class="colspan5" colspan="5">
          현재 등록된 게시물이 없습니다!
        </td>
      </tr>

      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td>{{ board.boardNo }}</td>
        <td><span class="noImageTmp">no Image</span></td>
        <td>
          <router-link :to="{ name: 'ProductsBoardReadView',
                              params: { boardNo:  board.boardNo.toString()  }}">
            {{ board.productName }}
          </router-link>
        </td>
        <td>{{ board.price }}</td>
      </tr>



    </table>
  </div>
</template>

<script>
export default {
  name: "ProductsBoardList",
  props: {
    boards: {
      type: Array
    }
  }
}
</script>

<style scoped>

.noImageTmp {
  background-color: #aaaaaa;
  color: #fff;
  font-size: 11px;
  text-align: center;
  display: block;
  width: 100px;
  margin: 0 auto;
}

table {
  width: 900px;
  margin: 0 auto;

}

tr, th, td {
  display: block;
  font-size: 13px;
  font-weight: normal;
}

table tr {
  border-bottom: 1px solid #111;
  display: flex;
  align-content: center;
  align-items: center;
}

table tr.divide {

  padding: 10px;
  border-radius: 10px;
  background-color: #2c3e50;
  color: #fff;
}

table tr td {
  padding: 8px 0;
  margin: 0 0 0 4px;
}


table tr th:nth-child(1) {
  width: 120px;
}
table tr th:nth-child(2) {
  width: 140px;
}
table tr th:nth-child(3) {
  width: 360px;
}
table tr th:nth-child(4) {
  width: 180px;
}

table tr td:nth-child(1) {
  width: 120px;
}
table tr td:nth-child(2) {
  width: 140px;
}
table tr td:nth-child(3) {
  width: 360px;
}
table tr td:nth-child(4) {
  width: 180px;
}

.colspan5 {
  width: 880px;
}
</style>