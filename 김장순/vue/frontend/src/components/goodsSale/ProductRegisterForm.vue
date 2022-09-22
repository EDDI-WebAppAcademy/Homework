<template>
  <form @submit.prevent="onSubmit" class="form">
    <div>
      <div class="banner">
        <h1 align="center">
          <router-link to="/goods-sale">테스트 굿즈샵</router-link>
        </h1>
      </div>
      <table>
        <tr>
          <td>상품명</td>
          <td>
            <input type="text" v-model="title" placeholder="상품명을 입력해주세요">
          </td>
        </tr>

        <tr>
          <td>판매자</td>
          <td>
            <input type="text" v-model="seller" placeholder="판매자명을 입력해주세요">
          </td>
        </tr>

        <tr>
          <td>가격</td>
          <td>
            <input type="text" v-model="price" placeholder="가격을 입력해주세요">&nbsp; 원
          </td>
        </tr>
        <tr>
          <td>제품설명</td>
          <td>
            <textarea cols="50" rows="20" v-model="content" placeholder="제품 설명을 입력해주세요">
          </textarea>
          </td>
        </tr>
      </table>
      <div>
        <button type="submit">등록</button>
        <router-link to='/goods-sale-list'>
          취소
        </router-link>
      </div>
    </div>
  </form>
</template>

<script>
export default {
  name: "ProductRegisterForm",
  data() {
    return {
      title: "",
      seller: "",
      price: "",
      content: ""

    }
  },
  methods: {
    onSubmit () {
      const { title, seller, price, content } = this
      this.$emit('submit', { title, seller, price, content })
    }
  }
}
</script>

<style scoped>
.form {
  margin-top: 100px;
}
.banner {
  margin-top: 100px;
  margin-bottom: 100px;
}
</style>