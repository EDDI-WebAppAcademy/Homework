<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>게시물 번호</td>
        <td>
          <input type="text" :value="goodsBoard.boardNo" disabled>
        </td>
      </tr>
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
        <td>등록일자</td>
        <td>
          <input type="text" :value="goodsBoard.regDate" disabled>
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
      <button type="submit">상품 게시물 수정완료</button>
      <router-link :to="{ name: 'GoodsBoardReadView',
                          params: {boardNo: goodsBoard.boardNo.toString() } }">
        상품 게시물 등록 취소
      </router-link>
    </div>
  </form>

</template>

<script>
export default {
  name: "GoodsBoardModifyForm",
  props: {
    goodsBoard: {
      type: Object,
      required:true,
    }
  },
  data() {
    return {
      goodsName: '',
      price: '',
      seller: '',
      content: '',
      regDate: '',
    }
  },
  created() {
    this.goodsName = this.goodsBoard.goodsName
    this.price = this.goodsBoard.price
    this.seller = this.goodsBoard.seller
    this.content = this.goodsBoard.content
    this.regDate = this.goodsBoard.regDate
  },
  methods: {
    onSubmit () {
      const { goodsName, price, seller, content, regDate } = this
      this.$emit('submit', { goodsName, price, seller, content, regDate })
    }
  }
}
</script>

<style scoped>

</style>