<template>
  <div class="home">
    <br/>
    <button v-on:click="colorChange">불고기 버거</button><br/>
    <button v-on:click="colorChange">치즈 버거</button><br/>
    <button v-on:click="colorChange">치킨 버거</button><br/>
    <button v-on:click="changeText"><v-btn class="pink">
      {{ text }}
    </v-btn></button>

  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {
  },

  data() {
    return{
      type: 'guest',
      text: '클릭 전',
      nextText: '클릭 후'
    }

  },

  methods: {
    clickHandler() {
      console.log("버튼이 클릭되었습니다.");

      alert("버튼이 클릭되었습니다.");
    },
    colorChange() {

    },
    changeText(){
      this.text = this.nextText
    }
  }
}
</script>

<style scoped>
</style>