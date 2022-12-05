<template>
  <div>
    <h4> 상품명: {{ goodsBoard.goodsName }}  가격: {{ goodsBoard.price }}</h4>
    수량 입력: <input type=number min="1" max="20" v-model.number="goodsAmount"/>
    <button>구매하기</button>
    <p>판매자 정보: {{ goodsBoard.seller }}</p>
    <textarea cols="50" rows="20" :value="goodsBoard.content" readonly>
          </textarea>
  </div>
</template>

<script>
export default {
  name: "GoodsBoardRead",
  props: {
    goodsBoard: {
      type: Object,
      required: true,
    },
    data() {
      return {
        goodsAmount: 0,
      }
    }
  }
}
</script>

<style scoped>

</style>