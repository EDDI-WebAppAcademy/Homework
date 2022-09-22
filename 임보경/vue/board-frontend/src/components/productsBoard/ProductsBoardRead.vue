<template>
  <div class="readWrap">
    <h3>Product Details</h3>

    <div class="readContent">
      <div><span class="noImage">no Image</span></div>

      <h4>
        <span v-if="hide">제품명</span>
        <input class="readonly" type="text" :value="board.productName" readonly>
      </h4>
      <p class="priceBox">
        <span v-if="hide">가격</span>
        <input class="readonly"  type="text" :value="board.price" readonly>
      </p>
      <p>
        <span v-if="hide">제품명</span>
        <textarea class="readonly"  :value="board.details"  cols="30" rows="10" readonly></textarea>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProductsBoardRead",
  data() {
    return {
      hide : false,
    }
  },
  props: {
    board: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>
.readonly {
  width: 300px;
  border: 0;
  text-align: center;
}

h4 {
  border-top: 1px solid #42b983;
  padding-top: 20px;
  width: 300px;
  margin: 20px auto 0;
}

h4 input{
  font-size: 20px;
  color: #222;
  font-weight: bold;
}

.priceBox{
  margin : 10px 0 20px;
}

p > input {
  font-size: 15px;
  color: #111111;

}

.noImage {
  display: block;
  margin: 0 auto;
  width: 180px;
  border-radius: 12px;
  padding: 80px 60px;
  background-color: #efefef;
  color: #999;
}


textarea.readonly {
  padding: 20px 0 0;
  border: 0;
  border-top: 1px solid #42b983;
  background-color: #fff;
  font-size: 13px;
  color: #42b983;

}

</style>