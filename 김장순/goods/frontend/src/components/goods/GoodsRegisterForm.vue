<template>
  <form @submit.prevent="onSubmit">
    <div>
      <h2>상품 등록</h2>
    </div>
    <div>
      <table>
        <tr>
          <th align="right">
            <a>상품명</a>
          </th>
          <th width="400px">
            <input type="text" placeholder="상품명을 입력해주세요" v-model="goodsName" class="input_box"><br>
          </th>
        </tr>
        <tr>
          <th align="right">
            <a>가격</a>
          </th>
          <th width="400px">
            <input type="text" placeholder="가격을 입력해주세요" v-model="price"><br>
          </th>
        </tr>
        <tr>
          <th align="right">
            <a>판매자</a>
          </th>
          <th width="400px">
            <input type="text" placeholder="판매자명을 입력해주세요" v-model="seller"><br>
          </th>
        </tr>
        <tr>
          <th align="right">
            <a>상품 설명</a>
          </th>
          <div>
            <th width="400px" height="300px">
              <textarea cols="50" rows="20" v-model="goodsDescription" placeholder="상품설명을 입력해주세요"></textarea>
            </th>
          </div>
        </tr>
      </table>
    </div>
    <div>
      <button type="submit">등록</button>&nbsp;
      <router-link to="/goods-board">취소</router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "GoodsRegisterForm",
  data() {
    return {
      goodsName: "",
      price: 0,
      seller: "",
      goodsDescription: ""
    }
  },
  methods: {
    onSubmit() {
      const {goodsName, price, seller, goodsDescription} = this
      this.$emit('submit', {goodsName, price, seller, goodsDescription})
    }
  }
}
</script>

<style scoped>
input {
  box-sizing: border-box;
  width: 100%;
  height: 50px;
  margin-top: 8px;
  padding: 0 12px;
  border: 1px solid #e5e5e5;
  border-radius: 4px;
  background-color: #fff;
  font-size: 15px;
  color: #000;
  box-shadow: 0 0 0 30px #fff inset !important;
  transition: border .2s ease-in-out;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}

textarea::placeholder {
  font-size: large;
  align-items: center;
}
</style>