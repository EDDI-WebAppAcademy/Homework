<template>
  <div align="center">
    <h2>aespa굿즈 상품 설명</h2>
    <jpa-board-read2 v-if="board2" :board2="board2"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'JpaBoardModifyView', params: { boardNo } }">
      게시물 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link to="/aespa-goods-list">돌아가기</router-link><br/><br/>
  </div>
</template>

<script>
import JpaBoardRead2 from "@/components/boards2/JpaBoardRead2";
import {mapActions, mapState} from "vuex";
export default {
  name: "JpaBoardReadView2",

  components: {JpaBoardRead2},
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board2'])
  },
  methods: {
    ...mapActions([
      'requestBoardFromSpring2',

    ]),
    async onDelete () {

    }

  },
  created() {
    this.requestBoardFromSpring2(this.boardNo)
  }
}
</script>

<style scoped>

</style>