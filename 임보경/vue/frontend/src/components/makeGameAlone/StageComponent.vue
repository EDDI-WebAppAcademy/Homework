<template>
  <section class="stageWrap">
    <h2> 스테이지 정보 </h2>

    <div>
      <h3>스테이지 {{ stageNumber }}</h3>
      <div class="buttons">
        <button @click="callRequestMonsterData">몬스터 소환</button>
      </div>

      <ul class="monstersOnStage">
        <li v-for="(monster, index) in monsters" :key="index">
          <button>스킬</button>
          {{ monster.name }} ----------- HP : {{ monster.hp }}
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
      monsters: [

      ],
    }
  },
  methods : {
      ...mapActions(['requestMonsterData']),

      async callRequestMonsterData() {
        await this.requestMonsterData()
        this.monsters = this.$store.state.monstersData
      },

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
  text-align: left;
}
ul, li {
  list-style: none;
  margin: 2px 0;
}

ul.monstersOnStage {
  margin-top: 30px;
}
</style>