<template>
  <div id="productBoardRead">
    <h2>상품 상세보기</h2>
    <router-link :to=" { name : 'ProductBoardMainView' } "> 돌아가기 </router-link>
    <product-board-read v-if="productBoard" :productBoard="productBoard"/>
    <p v-else>Now Loading......</p>
    <table v-if="isAdmin">
      <tr>
        <td>
          <button @click="toModifyThisProductBoard">수정</button>
        </td>
        <td>&nbsp;</td>
        <td>
          <button @click="deleteThisProduct(productNo)">삭제</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import ProductBoardRead from "@/components/productBoard/ProductBoardRead";
import {mapActions, mapState} from "vuex";

export default {
  name: "ProductBoardReadView",
  components: { ProductBoardRead },
  props: {
    productNo: {
      type: String,
      required: true,
    }
  },

  computed: {
    ...mapState(['productBoard', 'isAdmin'])
  },

  methods: {
    ...mapActions(['requestProductBoardRead', 'requestDeleteThisProductBoardToSpring']),

    async deleteThisProduct(productNo) {
      await this.requestDeleteThisProductBoardToSpring(productNo)
      await this.$router.push({
        name: 'ProductBoardMainView'
      })
    },

    toModifyThisProductBoard() {
      this.$router.push( {
        name: 'ProductBoardModifyView',
        params: { productNo: this.productNo }
      })
    }
  },

  created() {
    this.requestProductBoardRead(this.productNo)
  },

}
</script>

<style scoped>

</style>