<template>

  <fieldset>
    <button @click="addMonsterFromSpring">몬스터 부르기(10명)</button>
    <ul>
      <li v-for="(monster, index) in monsterListFromSpring" :key="index">
        몬스터 이름: {{monster.name}}   |   HP: {{monster.hp}} |
        <button @click="removeMonster(index)">몬스터 삭제하기</button>
      </li>
    </ul>
  </fieldset>
</template>

<script>

import { mapActions } from "vuex";

export default {
  name: "MonsterComponent",
  components: {
  },
  data() {
    return {
      monsterListFromSpring : [],
    }

  },
  methods: {

    ...mapActions(['requestRandomMonsterData']),
    async addMonsterFromSpring() {
      console.log('addMonsterFromSpring')
      await this.requestRandomMonsterData()
      for (let i = 0; i < this.$store.state.randomMonster.length; i++) {
        this.monsterListFromSpring.push(this.$store.state.randomMonster[i])
      }
    },

    removeMonster(index) {
      this.monsterListFromSpring.splice(index, 1)
    },

 /*   findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => {
            console.log("a: " + a + ", b: " + b.id);
            return a > b.id ? a : b.id
          }, 0)
    },*/

  }
}
</script>

<style scoped>

</style>