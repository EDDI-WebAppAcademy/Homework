<template>
  <form @submit.prevent="onSubmit">
    <table>
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
          <select id="category">
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
        <td>상세 정보</td>
        <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link to="{ name: 'ProductBoardReadView' }" >
        <button>
        취소
        </button>
      </router-link >
    </div>
  </form>
</template>

<script>
export default {
  name: "ProductBoardRegisterForm",
  data () {
    return {
      title: '상품명을 입력하세요',
      image: '상품 이미지를 등록하세요',
      category:  ,
      price: 9999999,
      writer: '판매자 상호를 입력하세요',
      content: '상품 상세 정보를 작성하세요',
    }
  },
  methods: {
    onSubmit () {
      const { title, image, category, price, writer, content } = this
      this.$emit('submit', { title, image, category, price, writer, content })
    }
  }
}
</script>

<style scoped>
</style>