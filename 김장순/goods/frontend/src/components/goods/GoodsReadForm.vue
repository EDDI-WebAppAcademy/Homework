<template>
  <div>
    <table>
      <tr>
        <th align="right">
          <a>상품명</a>
        </th>
        <th width="400px">
          <input type="text" :value="goods.goodsName" class="input_box"><br>
        </th>
      </tr>
      <tr>
        <th align="right">
          <a>가격</a>
        </th>
        <th width="400px">
          <input type="text" :value="goods.price"><br>
        </th>
      </tr>
      <tr>
        <th align="right">
          <a>판매자</a>
        </th>
        <th width="400px">
          <input type="text" :value="goods.seller"><br>
        </th>
      </tr>
      <tr>
        <th align="right">
          <a>상품 설명</a>
        </th>
        <div>
          <th width="400px" height="300px">
            <textarea cols="50" rows="20" :value="goods.goodsDescription"></textarea>
          </th>
        </div>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "GoodsReadForm",
  props: {
    goods: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>

</style>