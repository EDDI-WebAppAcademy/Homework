<template>
  <section class="stageWrap">
    <h2> 스테이지 정보 </h2>

    <div>
      <h3>스테이지 {{ stageNumber }}</h3>
      <div class="buttons">
        <button @click="callRequestMonsterData">몬스터 소환</button>
        <button @click="test">테스트</button>
      </div>

      <ul class="monstersOnStage">
        <li v-for="(monster, idx) in receiveMonstersData" :key="idx">
          여긴 받은 그룹 : {{ monster }}
        </li>

        <li v-for="mob in monsters" :key="mob.name">
          여긴 몬스터 : {{ mob }}
        </li>
      </ul>
    </div>

  </section>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "StageComponent",
  data() {
    return {
      stageNumber: 1,
      receiveMonstersData: [],
      monsters: [],
    }
  },
  methods : {
      ...mapActions(['requestMonsterData']),

      async callRequestMonsterData() {
        await this.requestMonsterData()
        this.receiveMonstersData = this.$store.state.monstersData
      },

      test() {
        let i = 0;
        let size = this.receiveMonstersData.length
        let monsterSize = this.monsters.length
        for ( i ; i < size ; i++) {
          this.monsters[monsterSize + i] = this.receiveMonstersData[i]
        }
        alert(monsterSize + " " + this.monsters[0].name)
      }
  }
}
</script>

<style scoped>
.buttons {
  display:flex;
  justify-content: space-evenly;
}
ul button {
  margin: 0 20px 0 15px;
}
ul {
  padding: 0 20px;

}
ul, li {
  list-style: none;
  margin: 2px 0;
}

ul.monstersOnStage {
  margin-top: 30px;
}

ul.monstersOnStage > li {
  display:flex;
  justify-content: space-between;
  text-align: left;
}
ul.monstersOnStage > li > span {
  margin-left: 15px;
}
</style>