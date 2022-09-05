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
          {{ monster[index].name }} ----------- HP : {{ monster[index].hp }}
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
        this.monsters.push(this.$store.state.monstersData)
        alert( this.monsters.length )
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

ul.monstersOnStage {
  margin-top: 30px;
}
</style>