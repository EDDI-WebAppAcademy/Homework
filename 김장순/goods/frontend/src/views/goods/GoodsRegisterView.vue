<template>
  <div>
    <goods-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import GoodsRegisterForm from "@/components/goods/GoodsRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "GoodsRegisterView",
  components: {
    GoodsRegisterForm
  },
  methods: {
    ...mapActions([
      'requestRegisterGoodsToSpring'
    ]),
    async onSubmit (payload){
      await this.requestRegisterGoodsToSpring(payload)

      await this.$router.push({
        name: 'GoodsBoardsView'
      })
    }
  }
}
</script>

<style scoped>

</style>