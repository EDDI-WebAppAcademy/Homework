<template>

  <div align="center">
    <h2>게시물 작성하기 </h2>

    <board-register-form @submit="onSubmit"/>


  </div>
</template>

<script>

import BoardRegisterForm from "@/components/boards/BoardRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "BoardRegisterView",
  components: {
    BoardRegisterForm
  },

  methods:{
    ...mapActions([

     'requestCreateBoardContentsToSpring'

    ]),
    async onSubmit (payload){

      await this.requestCreateBoardContentsToSpring(payload)
      await this.$router.push({

        name: 'MainBoardView'
      })

    }

  }


  }

</script>

<style scoped>

</style>