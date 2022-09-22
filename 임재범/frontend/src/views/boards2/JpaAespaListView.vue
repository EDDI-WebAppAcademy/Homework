<template>
  <div id="board">
<h2>aespa 굿즈상품 리스트</h2>
  <jpa-board-list2 :boards="boards"/>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import JpaBoardList2 from "@/components/boards2/JpaBoardList2";


export default {
  name: "JpaAespaListView.vue",
  components: {
    JpaBoardList2
  },
  computed: {
    ...mapState([
      'boards'
    ]),
  },
  mounted() {
    this.requestBoardListFromSpring2()
  },
  methods: {
    ...mapActions([
      'requestBoardListFromSpring2'
    ])
  }
}
</script>

<style scoped>

</style>