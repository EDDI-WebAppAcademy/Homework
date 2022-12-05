<template>
  <form @submit.prevent="onSubmit">
    <table>

      <tr>
        <td align="center">상품명</td>
        <td>
          <input type="text" v-model="productName">
        </td>
      </tr>

      <tr>
        <td align="center">가격</td>
        <td>
          <input type="number" v-model="price">
        </td>
      </tr>

      <tr>
        <td align="center">상세정보</td>
        <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>

    </table>

    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'ProductBoardMainView'}">돌아가기</router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "ProductBoardRegisterForm",
  data() {
    return {
      productName: '제목을 입력하세요',
      price: 0,
      content: '내용을 입력하세요',
    }
  },
  methods: {
    onSubmit() {
      const { productName, price, content } = this
      this.$emit('submit', { productName, price, content })
    }
  }
}
</script>

<style scoped>

</style>