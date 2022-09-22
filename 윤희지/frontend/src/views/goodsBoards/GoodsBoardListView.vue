<template>
  <div>
    <h2>상품 게시판</h2>
    <router-link :to="{ name: 'GoodsBoardRegisterView'}">
      상품 등록하기
    </router-link>
    <goods-board-list :goodsBoards="goodsBoardList"/>
    <br>
    <button> 로그인하기 </button>
  </div>

</template>

<script>
import GoodsBoardList from "@/components/goodsBoards/GoodsBoardList";
import {mapActions, mapState} from "vuex";

export default {
  name: "GoodsBoardListView",
  components: {
    GoodsBoardList
  },
  computed: {
    ...mapState([
        'goodsBoardList'
    ]),
  },
  mounted() {
    this.requestGoodsBoardListFromSpring()
  },
  methods: {
    ...mapActions([
        'requestGoodsBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>