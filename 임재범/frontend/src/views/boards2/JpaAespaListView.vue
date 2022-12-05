<template>
  <div id="board">
<h2>aespa 굿즈상품 리스트</h2><br/>

    <router-link :to="{ name: 'JpaBoardRegisterView2' }">
      판매물품 추가(관리자 메뉴)
    </router-link><br/><br/>

  <jpa-board-list2 :boards2="boards2"/>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import JpaBoardList2 from "@/components/boards2/JpaBoardList2";
import JpaBoardRegisterView2 from "@/views/boards2/JpaBoardRegisterView2";


export default {
  name: "JpaAespaListView.vue",
  components: {
    JpaBoardList2,
    // eslint-disable-next-line vue/no-unused-components
    JpaBoardRegisterView2,
  },
  computed: {
    ...mapState([
      'boards2'
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