<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>상품 번호</td>
        <td>
          <input type="text" :value="product.productNo" disabled>
        </td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" v-model="title">
        </td>
      </tr>
      <tr>
        <td>이미지</td>
        <td>
          <input type="text" v-model="image">
          <!--파일첨부 기능 X 버튼만 구현-->
          <button>파일 첨부</button>
        </td>
      </tr>
      <tr>
          <label for="category">카테고리</label>
        <td>
          <select v-model="category" onchange="this.form.category=this.value">
            <option value="Outer">Outer</option>
            <option value="T-shirt">T-shirt</option>
            <option value="Pants">Pants</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>가격</td>
        <td>
          <input type="text" v-model="price">
        </td>
      </tr>
      <tr>
        <td>판매자 상호</td>
        <td>
          <input type="text" v-model="writer">
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
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">수정</button>
      <router-link :to="{ name: 'ProductBoardReadView',
                        params: {productNo: product.productNo.toString() }}">
        <button>
        취소
        </button>
      </router-link >
    </div>
  </form>
</template>

<script>
export default {
  name: "ProductBoardModifyForm",
  props: {
    product: {
      type: Object,
      required: true,
    }
  },
  data () {
    return {
      title: '',
      image: '',
      category: '',
      price: '',
      writer: '',
      content: '',
      regDate: '',
    }
  },
  created () {
    this.title = this.product.title
    this.image = this.product.image
    this.category = this.product.category
    this.price = this.product.price
    this.writer = this.product.writer
    this.content = this.product.content
    this.regDate = this.product.regDate
  },
  methods: {
    onSubmit () {
      const { title, image, category, price, writer, content, regDate } = this
      this.$emit('submit', { title, image, category, price, writer, content, regDate })
    }
  }
}
</script>

<style scoped>
</style>