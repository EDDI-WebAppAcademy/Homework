<template>
  <div>
    <table>

      <tr>
        <td>상품 번호</td>
        <td>
          <input type="number" :value="productBoard.productNo" readonly>
        </td>
        <td>상품 등록 일자</td>
        <td>
          <input type="text" :value="productBoard.regDate" readonly>
        </td>
      </tr>

      <tr>
        <td>상품 이름</td>
        <td>
          <input type="text" :value="productBoard.productName" readonly>
        </td>
        <td>가격</td>
        <td>
          <input type="number" :value="productBoard.price" readonly>
        </td>
      </tr>

      <tr>
        <td colspan="4">
          <textarea cols="90" rows="20" :value="productBoard.content" readonly></textarea>
        </td>
      </tr>

    </table>
  </div>
</template>

<script>

export default {
  name: "ProductBoardRead",
  props: {
    productBoard: {
      type: Object,
      required: true,
    }
  }

}
</script>

<style scoped>

</style>