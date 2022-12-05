<template>
  <div class="wrap">
    <h2>수정하기</h2>

    <products-board-modify-form v-if="board" :board="board" @submit="onSubmit" />
    <p v-else>Loading .........</p>
  </div>
</template>

<script>
import ProductsBoardModifyForm from "@/components/productsBoard/ProductsBoardModifyForm";
import {mapActions, mapState} from "vuex";

export default {
  name: "ProductsBoardModifyView",
  components : { ProductsBoardModifyForm },
  props: {
    boardNo: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions([
      'requestBoardReadFromSpring',
      'requestProductsBoardModifyToSpring'
    ]),
    async onSubmit (payload) {
      const { productName, price, numberInStock, details } = payload
      const boardNo = this.boardNo

      await this.requestProductsBoardModifyToSpring({ boardNo, productName, price, numberInStock, details })
      await this.$router.push({
        name: 'ProductsBoardReadView',
        params: { boardNo: this.boardNo }
      })
    }
  },
  created () {
    this.requestBoardReadFromSpring(this.boardNo)
  }
}
</script>

<style scoped>

</style>