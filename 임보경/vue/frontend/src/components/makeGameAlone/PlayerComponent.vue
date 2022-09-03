<template>
  <section class="playerWrap">
    <h2> 플레이어 정보 </h2>

    <div class="buttons">
    <button @click="callRequestData" >로그인</button>
    <button disabled>정보갱신</button>
    </div>

    <h3>스테이터스</h3>
    <ul>
      <li> LEVEL : {{ player.level }}</li>
      <li> HP : {{ player.hp }}</li>
      <li> MP : {{ player.mp }}</li>
      <li> ATK : {{ player.atk }}</li>
      <li> MONEY : {{ player.money }}</li>
      <li> EXP : {{ player.currentExpBar }} / {{ player.totalExpBar }}</li>
    </ul>

    <h3>장비</h3>
  </section>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "PlayerComponent",
  data() {
    return {
      player: ''
      // mapState > states안의 값을 위의 player 저장
    }
  },
  methods : {
    ...mapActions(['requestPlayerDataFromSpring']),
    //actions에 있는 메소드를 가져옴. actions는 유틸리티 메서드
    async callRequestData() {
      // await 된 녀석이 일을 끝날 때까지 async 하지마
      // 쓰레드를 쓰는 이유 : 동시에 여러 일을 처리한다. > 빠르다.
      await this.requestPlayerDataFromSpring()
      this.player = this.$store.state.springFromVueTestValue
    },
  }
}
</script>

<style scoped>
.buttons {
  display:flex;
  justify-content: space-evenly;
}
ul {
  padding: 0 20px;
}
ul, li {
  list-style: none;
  margin: 2px 0;
}
</style>