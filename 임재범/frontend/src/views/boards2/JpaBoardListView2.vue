<template>
    <div id="board">

      <h2>관심 연예인 선택</h2>

      <router-link to="/aespa-goods-list">aespa 굿즈 샵</router-link><br/><br/>

      <router-link to="/RedVelvet-goods-list">Red Velvet 굿즈 샵</router-link><br/><br/>

      <router-link to="/GirlsGeneration-goods-list">Girls' Generation 굿즈 샵</router-link><br/><br/>

    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import JpaBoardList2 from "@/components/boards2/JpaBoardList2";

export default {
  name: "JpaBoardListView",
  components: {

    // eslint-disable-next-line vue/no-unused-components
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