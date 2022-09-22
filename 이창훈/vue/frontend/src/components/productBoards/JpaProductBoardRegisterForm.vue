<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" v-model="productName">
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" v-model="seller">
        </td>
      </tr>
      <tr>
        <td>가격</td>
        <td>
          <input type="text" v-model="price">
        </td>
      </tr>
      <tr>
        <td>판매 상품</td>
        <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'JpaProductBoardListView' }">
        취소
      </router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "JpaProductBoardRegisterForm",
  data () {
    return {
      productName: '상품 이름',
      seller: '판매자',
      price: '가격',
      content: '상품'
    }
  },
  methods: {
    onSubmit () {
      const { productName, seller, price, content} = this
      this.$emit('submit', { productName, seller, price, content })
    }
  }
}
</script>

<style scoped>

</style>