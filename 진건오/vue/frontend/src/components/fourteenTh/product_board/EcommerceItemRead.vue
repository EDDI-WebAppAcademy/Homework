<template>
  <div>
    <table>
      <tr>
        <td>상품번호</td>
        <td>
          <input type="text" :value="item.itemId" readonly>
        </td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" :value="item.itemName" readonly>
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" :value="item.seller" readonly>
        </td>
      </tr>
      <tr>
        <td>상품 가격</td>
        <td>
          <input type="text" :value="item.itemPrice" readonly>
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="item.regData" readonly>
        </td>
      </tr>
      <tr>
        <td>상세 정보</td>
        <td>
          <textarea cols="80" rows="30" :value="item.itemInformation" readonly></textarea>
        </td>
      </tr>
    </table>
<!--    <div align="center">-->
<!--      <router-link :to="{name: 'EcommerceBuyItemView', params: { itemId }}">-->
<!--        구매-->
<!--      </router-link> | -->
<!--      <router-link :to="{name: 'EcommerceConsumerListView'}">-->
<!--        취소-->
<!--      </router-link>-->
<!--    </div>-->
  </div>
</template>

<script>
export default {
  name: "EcommerceItemRead",
  props:{
    item:{
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>
</style>