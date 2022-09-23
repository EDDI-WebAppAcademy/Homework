<template>
  <form @submit.prevent="onSubmit">
    <table align="center">
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" v-model="name">
        </td>
      </tr>
      <tr>
        <td>상품 금액</td>
        <td>
          <input type="number" v-model="price">
        </td>
      </tr>
      <tr>
        <td>상품 재고</td>
        <td>
          <input type="number" v-model="stock">
        </td>
      </tr>
      <tr>
        <td>상품 설명</td>
        <td>
          <textarea cols="50" rows="20" v-model="description">
          </textarea>
        </td>
      </tr>

      <div>
        <button type="submit">등록</button>
        <router-link :to="{ name: 'ManagerProductBoardListView'}">
          취소
        </router-link>
      </div>
    </table>
  </form>
</template>

<script>
export default {
  name: "ProductBoardRegisterForm",
  data () {
    return {
      name: '',
      price: 0,
      stock: 0,
      description: ''
    }
  },
  methods: {
    onSubmit () {
      const { name, price, stock, description } = this
      this.$emit('submit', { name, price, stock, description })
    }
  }
}
</script>

<style scoped>

</style>