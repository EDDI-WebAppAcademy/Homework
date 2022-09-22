<template>
  <div>
    <h2>상품 정보 등록하기</h2>
    <goods-board-register-form @submit="onSubmit"/>
  </div>

</template>

<script>
import GoodsBoardRegisterForm from "@/components/goodsBoards/GoodsBoardRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "GoodsBoardRegisterView",
  components: {
    GoodsBoardRegisterForm
  },
  methods: {
    ...mapActions([
        'requestCreateGoodsBoardContentsToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestCreateGoodsBoardContentsToSpring(payload)

      await this.$router.push({
        name: 'GoodsBoardListView'
      })
    }
  }
}
</script>

<style scoped>

</style>