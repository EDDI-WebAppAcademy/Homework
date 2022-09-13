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

      // monsterBooks: [
      //   { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
      //   { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10 },
      //   { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20 },
      //   { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20 },
      //   { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10 },
      //   { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40 },
      //   { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50 },
      //   { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50 },
      //   { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80 },
      //   { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50 },
      //   { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300 },
      //   { monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50 },
      //   { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1 },
      //   { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100 },
      //   { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150 },
      //   { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500 },
      //   { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100 },
      //   { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700 },
      //   { monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000 },
      //   { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000 },
      //   { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000 },
      //   { monsterId: 9999, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 5000000, dropMoney: 10000000 }
      // ],
      // monsterLists: [
      //   // { id: 1, name: '슬라임', hp: 50 },
      //   // { id: 2, name: '고블린', hp: 100 },
      //   // { id: 3, name: '놀', hp: 200 },
      // ],
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