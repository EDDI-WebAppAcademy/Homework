<template>
  <div>
    <table>
      <tr>
        <td>상품 번호</td>
        <td>
          <input type="text" :value="productBoard.productNo" readonly>
        </td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" :value="productBoard.productName" readonly>
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" :value="productBoard.seller" readonly>
        </td>
      </tr>
      <tr>
        <td>가격</td>
        <td>
          <input type="text" :value="productBoard.price" readonly>
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="productBoard.regDate" readonly>
        </td>
      </tr>
      <tr>
        <td>상품 정보</td>
        <td>
          <textarea cols="50" rows="20" :value="productBoard.content" readonly>
          </textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaProductBoardRead",
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