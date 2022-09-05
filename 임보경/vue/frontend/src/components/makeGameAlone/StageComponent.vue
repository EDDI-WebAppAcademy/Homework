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
          <span>{{ monster.name }} ----------- HP : {{ monster.hp }}</span>
          <button>나중에 스킬 구현</button>
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