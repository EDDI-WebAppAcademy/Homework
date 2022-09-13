<template>
  <div>
    <h3>몬스터</h3>

    <button @click="callRequestMonsterFromSpring" type="button">기본 몬스터(고정) 셋팅</button>
    <button @click="callRequestRandomMonster" type="button">랜덤 몬스터 추가</button>
    <button @click="callRequestManyRandomMonster" type="button">랜덤 몬스터 100마리 추가</button><br/>

    <p>몬스터리스트</p>
    <ul>
      <li v-for="(monster, index) in returnMonsterListsValue" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
      </li>
    </ul>

  </div>

</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "MonsterManager",
  data () {
    return {

      returnMonsterListsValue:[],
    }
  },
  methods: {
    ...mapActions([
      'requestMonsterFromSpring',
      'requestRandomMonster',
      'requestManyRandomMonster'
    ]),
                                                               //mapActions는 actions.js에 있는 메소드 써주는 건데 자바로 치면 유틸리티 메소드, 액션에 배치하는 건 다 쓰레드 베이스
    async callRequestMonsterFromSpring() {                 // 데이터 요청이 응답보다 처리가 무겁기 때문에 async/ await를 통해 응답이 요청처리 기다리도록 만들어줌
      await this.requestMonsterFromSpring()            //actons에 작성된 메소드     // 처리가 오래걸리는 요청메소드 앞에 await 써줌 -> 즉, requestDataFromSpring() 메소드 실행이 완료되면 그 다음 응답부분인 returnValue 코드 실행
      this.returnMonsterListsValue = this.$store.state.monsterValue            // 응답되어 스프링에서 결과값 받아오는 부분

    },
    async callRequestRandomMonster() {
      await this.requestRandomMonster()
      this.returnMonsterListsValue = this.$store.state.randomMonsterValue

    },

    async callRequestManyRandomMonster() {
      await this.requestManyRandomMonster()
      this.returnMonsterListsValue = this.$store.state.manyRandomMonsterValue

    },

  }
}
</script>

<style scoped>
</style>