<template>
  <div align="center">
    <h2>상품리스트</h2>
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
      'requestCreateBoardContentsToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestCreateBoardContentsToSpring(payload)

      await this.$router.push({
        name: 'JpaBoardListView'
      })
    }
  }
}
</script>

<style scoped>

</style>