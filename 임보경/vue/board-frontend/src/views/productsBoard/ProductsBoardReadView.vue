<template>

  <div class="boardReadPage">
    <h3>READ PAGE</h3>

    <products-board-read v-if="board" :board="board"/>
    <p v-else>Loading .......</p>

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