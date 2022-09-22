<template>
  <div>

    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="640">상품명</th>
        <th align="center" width="150">판매자</th>
        <th align="center" width="240">등록일자</th>
      </tr>
      <tr v-if="!boards2 || (Array.isArray(boards2) && boards2.length === 0)">
        <td colspan="4">
          현재 등록된 게시물이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="board in boards2" :key="board.boardNo">
        <td align="center">
          {{ board.boardNo }}
        </td>
        <td align="left">
          <router-link :to="{ name: 'JpaBoardReadView',
                              params: { boardNo: board.boardNo.toString() }}">
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">
          {{ board.writer }}
        </td>
        <td align="center">
          {{ board.regDate }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaBoardList2",
  props: {
    boards2: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>