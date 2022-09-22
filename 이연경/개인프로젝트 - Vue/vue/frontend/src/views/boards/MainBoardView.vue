<template>

  <div>

    <h2>{{ text }}</h2> <br>

    <button @click="onClickRedirect()"> 상품 1 </button> <br><br>

    <button @click="onClickRedirect()"> 상품 2</button> <br><br>

    <button @click="onClickRedirect()"> 상품 3</button> <br><br>

    <button @click="onClickRedirect()"> 상품 4</button> <br><br>

    <button @click="onClickRedirect()"> 상품 5</button> <br><br>



  </div>


</template>

<script>
export default {
  name: "MainBoardView",
  components: {},

  data() {

    return {

      text: " 상품 메인 페이지 입니다"

    }

  },

  methods: {

    onClickRedirect: function () {
      window.open("https://google.com", "_blank");

    }


  }
}

</script>

<style scoped>

</style>