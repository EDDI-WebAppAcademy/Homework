<template>
  <fieldset>
    <button @click="addRandomMonster()">컴포넌트 분리 랜덤 몬스터</button>
    <button @click="addManyMonsters()"> 컴포넌트 분리 랜덤 몬스터 뭉치</button>
    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{monster.name}}   |   HP: {{monster.hp}}
      </li>
    </ul>
  </fieldset>
</template>

<script>
export default {
  name: "MonsterComponent",
  data() {
    return {
      monsterBooks: [
        { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
        { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10},
        { monsterId: 3, name: '놉', hp: 200, exp: 40, dropMoney: 20},
        { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20},
        { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10},
        { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40},
        { monsterId: 7, name: '홉고블린', hp: 650, exp: 100, dropMoney: 50},
        { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50},
        { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80},
        { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50},
        { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300},
        { monsterId: 12, name: '오거', hp: 1000, exp: 250, dropMoney: 50},
        { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1},
        { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100},
        { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150},
        { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500},
        { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100},
        { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 50},
        { monsterId: 19, name: '미노타우르스', hp: 10000, exp: 1500, dropMoney: 1000},
        { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000},
        { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 20000, dropMoney: 100000},
        { monsterId: 9999, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 5000000, dropMoney: 10000000 }
      ],
      monsterLists: [
        {id: 1, name: '슬라임', hp: 50},
        {id: 2, name: '고블린', hp: 100},
        {id: 3, name: '오크', hp: 150 },
      ],

    }

  },
  methods: {
    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => {
            console.log("a: " + a + ", b: " + b.id);
            return a > b.id ? a : b.id
          }, 0)
    },

    addRandomMonster() {
      let max = this.findCurrentMonsterListMax()
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)

      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },

    addManyMonsters(){
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },

  }
}
</script>

<style scoped>

</style>