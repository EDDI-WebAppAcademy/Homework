<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>상품 번호</td>
          <td>
            <input type="text" :value="productBoard.productNo" disabled>
          </td>
        </tr>
        <tr>
          <td>상품명</td>
          <td>
            <input type="text" v-model="productName">
          </td>
        </tr>
        <tr>
          <td>판매자</td>
          <td>
            <input type="text" :value="productBoard.seller" disabled>
          </td>
        </tr>
        <tr>
          <td>가격</td>
          <td>
            <input type="text" v-model="price">
          </td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td>
            <input type="text" :value="productBoard.regDate" disabled>
          </td>
        </tr>
        <tr>
          <td>상품 정보</td>
          <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
          </td>
        </tr>
      </table>

      <div>
        <button type="submit">수정 완료</button>
        <router-link :to="{ name: 'JpaProductBoardReadView',
                            params: { productNo: productBoard.productNo.toString() } }">
          취소
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "JpaProductBoardModifyForm",
  props: {
    productBoard: {
      type: Object,
      required: true,
    }
  },
  data() {
    return {
      productName: '',
      seller: '',
      price: 0,
      regDate: '',
      content: '',
    }
  },
  created() {
    this.productName = this.productBoard.productName
    this.seller = this.productBoard.seller
    this.price = this.productBoard.price
    this.regDate = this.productBoard.regDate
    this.content = this.productBoard.content
  },
  methods: {
    onSubmit () {
      const { productName, seller, price, regDate, content } = this
      this.$emit('submit', { productName, seller, price, regDate, content })
    }
  }
}
</script>

<style scoped>

</style>