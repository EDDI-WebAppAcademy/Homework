<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" v-model="goodsName">
        </td>
      </tr>
      <tr>
        <td>가격</td>
        <td>
          <input type="text" v-model="price">
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" v-model="seller">
        </td>
      </tr>
      <tr>
        <td>상품 상세설명</td>
        <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">상품 게시물 등록</button>
      <router-link to="{ name: 'GoodsBoardListView' }">
        상품 게시물 등록 취소
      </router-link>
    </div>
  </form>

</template>

<script>
export default {
  name: "GoodsBoardRegisterForm",
  data() {
    return {
      goodsName: '상품명을 입력하세요',
      price: '상품 가격을 입력하세요',
      seller: '판매자의 이름 입력하세요',
      content: '상품 설명을 입력하세요'
    }
  },
  methods: {
    onSubmit () {
      const { goodsName, price, seller, content } = this
      this.$emit('submit', { goodsName, price, seller, content })
    }
  }
}
</script>

<style scoped>

</style>