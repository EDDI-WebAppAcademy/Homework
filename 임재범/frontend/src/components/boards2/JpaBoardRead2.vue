<template>
  <div>
    <table>
      <tr>
        <td>게시물 번호</td>
        <td>
          <input type="text" :value="board2.boardNo" readonly>
        </td>
      </tr>
      <tr>
        <td>상품이름</td>
        <td>
          <input type="text" :value="board2.title" readonly>
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" :value="board2.writer" readonly>
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="board2.regDate" readonly>
        </td>
      </tr>
      <tr>
        <td>상품설명</td>
        <td>
          <textarea cols="50" rows="20" :value="board2.content" readonly>
          </textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaBoardRead2",
  props: {
    board2: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>

</style>