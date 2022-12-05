<template>
  <form @submit.prevent="onSubmit">

    <div class="productRegisterFormTable">

        <ul class="area leftArea">
          <li>
            <label for="productName">상품명</label>
            <input type="text" v-model="productName">
          </li>
          <li>
            <label for="price">가격</label>
            <input type="text" v-model="price">
          </li>
          <li>
            <label for="numberInStock">재고 수</label>
            <input type="text" v-model="numberInStock">
          </li>
        </ul>
        
        <ul class="area">
          <li>
            <label for="details">상품 설명</label>
            <textarea cols="30" rows="10" v-model="details"></textarea>
          </li>
        </ul>

    </div>

    <div class="buttonArea">
      <button type="submit" class="mainButton" >등록하기</button>
      <router-link to="{ name: 'ProductBoardListView' }" class="subButton">
        취소
      </router-link>
    </div>

  </form>
</template>

<script>
export default {
  name: "ProductRegisterForm",
  data() {
    return {
      productName : '상품명',
      price : 12000,
      numberInStock : 10,
      details: '간략한 상품설명을 여기에 적어주세요.'
    }
  },
  methods: {
    onSubmit () {
      const { productName, price, numberInStock, details } = this
      this.$emit('submit', { productName, price, numberInStock, details })
    },
  }
}
</script>

<style scoped>


.productRegisterFormTable {
  width: 800px;
  margin: 0 auto;
  padding: 10px 20px;
  border-radius: 12px;
  border: 1px solid #42b983;

  display: flex;
  justify-content: space-between;
  align-content: center;
}

.area {
  width: 400px;
  margin: 0;
  padding: 0;
}

.area > li {
  display: flex;
  justify-content: normal;
  align-items: center;

}

.area li label {
  width: 96px;
  margin: 0 30px 0 0;
  font-size: 14px;
}

.area li input {
  width: 180px;
  font-size: 12px;
  color: #777;
  border: 0;
  background-color: #eee;
  border-radius: 18px;
  padding: 11px 20px;
}

.area li textarea {
  width: 220px;
  margin-top: 10px;
  font-size: 12px;
  color: #777;
  border: 0;
  background-color: #eee;
  border-radius: 18px;
  padding: 20px;
  height: 120px;
}

.leftArea {
  border-right: 1px solid #ddd;
}
.leftArea > li {
  height: 60px;
}

.buttonArea {
  margin: 40px auto;
}



.buttonArea button {
  margin: 0 6px;
  padding: 11px 15px;
  border-radius: 8px;
  border: 0;
  font-size: 12px;
  cursor: pointer;
}

.mainButton {
  background-color: #42b983;
  color: #fff;
}

.subButton {
  font-size: 12px;
  margin: 0 6px;
  padding: 13px 15px;
  border-radius: 8px;
  border: 0;
  background-color: #eee;
  text-decoration: none;
  color: #777;
}
</style>