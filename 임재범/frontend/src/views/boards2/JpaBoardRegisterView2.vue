<template>
  <div align="center">
    <h2>Aespa 굿즈 상품 등록</h2>
    <jpa-board-register-form2 @submit="onSubmit"/>
  </div>
</template>

<script>

import JpaBoardRegisterForm2 from "@/components/boards2/JpaBoardRegisterForm2";
import {mapActions} from "vuex";

export default {
  name: "JpaBoardRegisterView2",
  components: {
    JpaBoardRegisterForm2
  },
  methods: {
    ...mapActions([
      'requestCreateBoardContentsToSpring2'
    ]),
    async onSubmit (payload) {
      await this.requestCreateBoardContentsToSpring2(payload)

      await this.$router.push({
        name: 'JpaBoardListView2'
      })
    }
  }
}
</script>

<style scoped>

</style>