<template>
  <div>
    <button @click="addManyRandomMonster">랜덤 몬스터 100마리 추가</button>
    <br/>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
        <button v-on:click="removeMonster(index)">맵에 끼어있는 몬스터 삭제하기</button>
        <button v-on:click="darknessBlade(index)">Darkness Blade</button>
      </li>
    </ul>
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "MonsterManager",
  data() {
    return {
      monsterBooks: [],
      monsterLists: [],
    }
  },
  methods: {
    ...mapActions(['requestRandomMonsters',
      'requestRemoveMonsterIdx'
    ]),
    async addManyRandomMonster() {
      await this.requestRandomMonsters()

      this.monsterLists = this.$store.state.randomMonster
    },
    async removeMonster(index) {
      let removeMonsterIdx = index
      let payload = { removeMonsterIdx }
      await this.requestRemoveMonsterIdx(payload)

      this.monsterLists = this.$store.state.randomMonster
    }
  }
}


</script>

<style scoped>

</style>