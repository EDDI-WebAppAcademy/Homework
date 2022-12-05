<template>
  <div>
    <h2>상품 게시물 수정</h2>
    <goods-board-modify-form v-if="goodsBoard" :goodsBoard="goodsBoard" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>

<script>

import {mapActions, mapState} from "vuex";
import GoodsBoardModifyForm from "@/components/goodsBoards/GoodsBoardModifyForm";

export default {
  name: "GoodsBoardModifyView",
  components: {
    GoodsBoardModifyForm
  },
  props: {
    boardNo: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['goodsBoard'])
  },
  methods: {
    ...mapActions([
      'requestGoodsBoardFromSpring',
      'requestModifyGoodsBoardContentsToSpring'
    ]),
    async onSubmit(payload) {
      const { goodsName, price, seller, content, regDate } = payload
      const boardNo = this.boardNo

      await this.requestModifyGoodsBoardContentsToSpring({ boardNo, goodsName, price, seller, content, regDate })
      await this.$router.push({
        name: 'GoodsBoardReadView',
        params: { boardNo: this.boardNo }
      })
    }
  },
  created() {
    this.requestGoodsBoardFromSpring(this.boardNo)
  }
}
</script>

<style scoped>

</style>