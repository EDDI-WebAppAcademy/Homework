<template>
  <table>
    <tr>
      <td>상품명</td>
      <td>
        <input type="text" :value="product.title" disabled>
      </td>
    </tr>
    <tr>
      <td>이미지</td>
      <td>
        <input type="text" :value="product.image" disabled>
        <!--파일첨부 기능 X 버튼만 구현-->
        <button>파일 첨부</button>
      </td>
    </tr>
    <tr>
      <label for="category">카테고리</label>
      <td>
        <select :value="product.category" disabled>
          <option value="Outer">Outer</option>
          <option value="T-shirt">T-shirt</option>
          <option value="Pants">Pants</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>가격</td>
      <td>
        <input type="text" :value="product.price" disabled>
      </td>
    </tr>
    <tr>
      <td>판매자 상호</td>
      <td>
        <input type="text" :value="product.writer" disabled>
      </td>
    </tr>
    <tr>
      <td>등록일자</td>
      <td>
        <input type="text" :value="product.regDate" disabled>
      </td>
    </tr>
    <tr>
      <td>상세 정보</td>
      <td>
      <textarea cols="50" rows="20" :value="product.content" disabled>
      </textarea>
      </td>
    </tr>
  </table>
</template>

<script>
export default {
  name: "ProductBoardRead",
  props: {
    product: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>
</style>