<template>

  <div class="boardReadPage">
    <h3>READ PAGE</h3>

    <products-board-read v-if="board" :board="board"/>
    <p v-else>Loading .......</p>


    <router-link class = "mainButton" :to="{ name: 'ProductsBoardModifyView', params: { boardNo } }">
      게시물 수정
    </router-link>
    <router-link class = "subButton" :to="{ name: 'ProductsBoardListView' }">
      돌아가기
    </router-link>
  </div>


</template>

<script>

import ProductsBoardRead from "@/components/productsBoard/ProductsBoardRead";
import {mapActions, mapState} from "vuex";

export default {
  name: "ProductsBoardReadView",
  components : {
    ProductsBoardRead
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions([
      'requestBoardReadFromSpring'
    ]),
  },
  created() {
    this.requestBoardReadFromSpring(this.boardNo)
  }
}
</script>

<style scoped>


.mainButton {
  text-decoration: none;
  margin: 0 6px;
  padding: 11px 15px;
  border-radius: 8px;
  border: 0;
  font-size: 12px;
  cursor: pointer;
  background-color: #42b983;
  color: #fff;
}

.subButton {
  font-size: 12px;
  margin: 0 6px;
  padding: 13px 15px;
  border-radius: 8px;
  border: 0;
  background-color: #eee;
  text-decoration: none;
  color: #777;
}
</style>