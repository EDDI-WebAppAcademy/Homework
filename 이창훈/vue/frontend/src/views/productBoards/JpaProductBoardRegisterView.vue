<template>
  <div align="center">
    <h2>상품등록</h2>
    <jpa-product-board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import JpaProductBoardRegisterForm from "@/components/productBoards/JpaProductBoardRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "JpaProductBoardRegisterView",
  components: {
    JpaProductBoardRegisterForm
  },
  methods: {
    ...mapActions([
        'requestCreateProductBoardContentsToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestCreateProductBoardContentsToSpring(payload)
      await this.$router.push({
        name: 'JpaProductBoardListView'
      })
    }
  },
}
</script>

<style scoped>

</style>