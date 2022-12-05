<template>
  <div>
    <button @click="addRandomMonster">(Local)랜덤 몬스터 추가하기</button>
    <button @click="addManyRandomMonster">(Local)랜덤 몬스터 100마리 추가하기</button>
    <button @click="darknessTwilightBrightnessDawnRagnaBlade()">Darkness Twilight Brightness Dawn RagnaBlade</button>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
        <button v-on:click="removeMonster(index)">맵에 끼어 있는 몬스터 삭제하기</button>
        <button @click="darknessDeathDestinyTypoonBlade(index)">Darkness Death Destiny Typoon Blade</button>
      </li>
    </ul>

  </div>


</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "MonsterManager",
  mounted () {
    this.viewMonsterList()
  },
  /*
  몬스터 데이터를 상위 컴포넌트에서 가져오지 않아도 되고 그 자체를 여기서 데이터화 시킴
  props: {
    monsterBooks: [],
    monsterLists: [],
  },
  */
  data () {
    return {
      monsterBooks: [
        // { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
        // { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10 },
        // { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20 },
        // { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20 },
        // { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10 },
        // { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40 },
        // { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50 },
        // { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50 },
        // { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80 },
        // { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50 },
        // { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300 },
        // { monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50 },
        // { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1 },
        // { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100 },
        // { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150 },
        // { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500 },
        // { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100 },
        // { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700 },
        // { monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000 },
        // { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000 },
        // { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000 },
        // { monsterId: 9999, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 5000000, dropMoney: 10000000 }
      ],
      monsterLists: [
        // { id: 1, name: '슬라임', hp: 50 },
        // { id: 2, name: '고블린', hp: 100 },
        // { id: 3, name: '놀', hp: 200 },
      ],
    }
  },
  methods: {
    ...mapActions([
        'requestRandomMonster',
        'requestMonsterList'
    ]),
    darknessDeathDestinyTypoonBlade() {
    },
    darknessTwilightBrightnessDawnRagnaBlade() {
    },

  //   darknessDeathDestinyTypoonBlade (index) {
  //     console.log("어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니 " +
  //         "간닷! 다크니스 데스 데스티니 타이푼 블레이드!!!!!!!!!!!")
  //     this.monsterLists[index].hp =
  //         this.monsterLists[index].hp -
  //         Math.floor(
  //             this.characterStatus.atk * 70 +
  //             this.characterStatus.str * 33 +
  //             this.characterStatus.dex * 30 +
  //             this.characterStatus.intelligence * 30
  //         )
  //   },
  //   darknessTwilightBrightnessDawnRagnaBlade () {
  //     console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
  //         "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!")
  //     for (let i = 0; i < this.monsterLists.length; i++) {
  //       this.monsterLists[i].hp -= 30 * this.characterStatus.atk
  //     }
  //   }
  // },
    async viewMonsterList () {
      await this.requestMonsterList()
      this.monsterLists = this.$store.state.monsterList
    },
/*    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => { console.log("a: " + a + ", b.id: " + b.id); return a > b.id ? a : b.id },
          0)
    },*/
    async addRandomMonster () {
      await this.requestRandomMonster()
      this.monsterLists = this.$store.state.randomMonster
    },
    /*addRandomMonster () {
      let max = this.findCurrentMonsterListMax()
      // ex) 20개라면 0 ~ 19.xxx 까지인데 floor 버림이니까 0 ~ 19까지
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)
      // eslint-disable-next-line vue/no-mutating-props
      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },*/
    addManyRandomMonster () {
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },
        removeMonster (index) {
          // 새로운 개념: splice는 ?
          // 리스트에서 index 파트를 특정 개수만큼 잘라낸다.
          // splice(index, 1)이므로 index에 해당하는 정보 1개를 삭제한다라는 뜻입니다.
          // 해당 index 1개, (0, 1)이면 0번째 인덱스 1개 삭제, (0, 3)이면 0, 1, 2번째 인덱스 총 3개 삭제
          this.monsterLists.splice(index, 1)
        },
  }
}
</script>

<style scoped>

</style>