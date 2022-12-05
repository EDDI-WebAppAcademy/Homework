<template>
  <div>
    <table border="1">

      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="640">name</th>
        <th align="center" width="150">price</th>
        <th align="center" width="100">in basket</th>
      </tr>
      <tr v-if="!productBoardList || (Array.isArray(productBoardList) && productBoardList.length === 0)">
        <td align="center" colspan="4">
          현재 등록된 상품이 없습니다!
        </td>
      </tr>

      <tr v-else v-for="productBoard in productBoardList" :key="productBoard.productNo">

        <td align="center">
          {{ productBoard.productNo }}
        </td>

        <td align="left">
          <router-link :to="{ name: 'ProductBoardReadView',
           params: { productNo : productBoard.productNo.toString() }}">
            {{ productBoard.productName }}
          </router-link>
        </td>

        <td align="center">
          {{ productBoard.price }}
        </td>

        <td align="center">
          <button @click="inShoppingBasket(productBoard.productNo)">
            장바구니
          </button>
        </td>

      </tr>
    </table>
  </div>



</template>

<script>
export default {
  name: "ProductBoardList",

  props: {
    productBoardList: {
      type: Array
    }
  },

  methods: {
    inShoppingBasket(productNo){
      console.log(productNo)
    }
  }
}
</script>

<style scoped>

</style>