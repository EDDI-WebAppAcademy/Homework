<template>
  <div>
    <h2>상품 상세페이지</h2>
    <goods-board-read v-if="goodsBoard" :goodsBoard="goodsBoard"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'GoodsBoardModifyView', params: { boardNo } }">
      게시물 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'GoodsBoardListView' }">
      돌아가기
    </router-link>
  </div>
</template>

<script>
import GoodsBoardRead from "@/components/goodsBoards/GoodsBoardRead";
import {mapActions, mapState} from "vuex";
export default {
  name: "GoodsBoardReadView",
  components: {GoodsBoardRead},
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['goodsBoard'])
  },
  methods: {
    ...mapActions([
        'requestGoodsBoardFromSpring',
        'requestDeleteGoodsBoardToSpring'
    ]),
    async onDelete () {
      await this.requestDeleteGoodsBoardToSpring(this.boardNo)
      await this.$router.push({ name: 'GoodsBoardListView' })
    }
  },
  created() {
    this.requestGoodsBoardFromSpring(this.boardNo)
  }
}
</script>

<style scoped>

</style>