<template>
  <div>
    <form @submit.prevent="onSubmit()">
      <table>
        <tr>
          <td>상품 번호</td>
          <td>
            <input type="number" :value="productBoard.productNo" disabled>
          </td>
          <td>상품 등록 일자</td>
          <td>
            <input type="text" :value="productBoard.regDate" disabled>
          </td>
        </tr>

        <tr>
          <td>상품 이름</td>
          <td>
            <input type="text" v-model="productName">
          </td>
          <td>가격</td>
          <td>
            <input type="number" v-model="price">
          </td>
        </tr>

        <tr>
          <td colspan="4">
            <textarea cols="90" rows="20" v-model="content"></textarea>
          </td>
        </tr>

      </table>

      <div>
        <table>
          <tr>
            <td>
              <button type="submit">수정 완료</button>
            </td>
            <td>&nbsp;</td>
            <td>
              <router-link :to=" { name: 'ProductBoardReadView',
                             params: { productNo: productBoard.productNo.toString()} }" >취소</router-link>
            </td>
          </tr>
        </table>
      </div>

    </form>
  </div>
</template>

<script>
export default {
  name: "ProductBoardModifyForm",
  props: {
    productBoard: {
      type: Object,
      required: true,
    }
  },
  data() {
    return {
      regDate: '',
      productName: '',
      price: 0,
      content: '',
    }
  },
  created() {
    this.regDate = this.productBoard.regDate
    this.productName = this.productBoard.productName
    this.price = this.productBoard.price
    this.content = this.productBoard.content
  },

  methods: {
    onSubmit() {
      const { regDate, productName, price, content } = this
      this.$emit('submit', { regDate, productName, price, content } )
    }
  }
}
</script>

<style scoped>

</style>