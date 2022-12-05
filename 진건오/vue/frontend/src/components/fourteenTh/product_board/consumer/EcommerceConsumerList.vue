<template>
  <div>
    <div align="center">
      <h2>E-SHOP</h2>
      <button @click="onLogin" style="margin-right: 910px; margin-bottom: 10px">로그인</button>
      <table border="1">
        <tr>
          <th align="center" width="80">상품 번호</th>
          <th align="center" width="560">상품 명</th>
          <th align="center" width="150">판매자</th>
          <th align="center" width="150">상품 가격</th>
        </tr>
        <tr v-if="!items || (Array.isArray(items) && items.length === 0)">
          <td colspan="4" >
            <p align="center">현재 등록된 상품이 없습니다.</p>
          </td>
        </tr>
        <tr v-else v-for="item in items" :key="item.itemId">
          <td align="center">
            {{ item.itemId }}
          </td>
          <td align="left">
            <router-link :to="{name: 'EcommerceItemReadView', params: {itemId: item.itemId.toString()}}">
              {{ item.itemName }}
            </router-link>
          </td>
          <td align="right">
            {{ item.seller }}
          </td>
          <td align="center">
            {{ item.itemPrice }}
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>

export default {
  name: "EcommerceConsumerList",
  props:{
    items:{
      type: Array
    }
  },
  methods:{
    onLogin() {
      this.$router.push({name: 'EcommerceLoginView'})
    },
  }
}
</script>

<style scoped>

</style>