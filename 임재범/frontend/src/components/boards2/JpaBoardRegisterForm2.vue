<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>상품이름</td>
        <td>
          <input type="text" v-model="title">
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" v-model="writer">
        </td>
      </tr>
      <tr>
        <td>상품설명</td>
        <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link to="/aespa-goods-list">
        취소
      </router-link>
    </div>
  </form>
</template>

<script>

export default {
  name: "JpaBoardRegisterForm2",
  data () {
    return {
      title: '상품이름을 입력하세요',
      writer: '판매자 이름을 입력하세요',
      content: '상품에 대한 설명을 적어주세요',
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>

<style scoped>

</style>