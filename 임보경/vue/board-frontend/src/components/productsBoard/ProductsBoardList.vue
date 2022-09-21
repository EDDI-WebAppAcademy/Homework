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
        <td colspan="5">
          현재 등록된 게시물이 없습니다!
        </td>
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
}

table tr.divide {
  display: flex;

  padding: 10px;
  border-radius: 10px;
  background-color: #2c3e50;
  color: #fff;
}

table tr td {
  padding: 8px 0;
}


table tr th:nth-child(1) {
  width: 120px;
}
table tr th:nth-child(2) {
  width: 120px;
}
table tr th:nth-child(3) {
  width: 360px;
}
table tr th:nth-child(4) {
  width: 180px;
}
</style>