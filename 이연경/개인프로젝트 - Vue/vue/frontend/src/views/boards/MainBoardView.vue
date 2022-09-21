<template>

  <div id="board">

    <h2>{{ maintext }}</h2> <br>
    <router-link :to="{ name: 'BoardRegisterView' }"> </router-link>
      게시물 작성


  </div>


</template>

<script>
export default {
  name: "MainBoardView",

  data() {

    return {

      maintext: " 상품 메인 페이지 입니다"

    }
  }
}


</script>

<style scoped>

</style>