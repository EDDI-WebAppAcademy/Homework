<template>
  <div>
    <button @click="addManyRandomMonster">(Local Component)랜덤 몬스터 100마리 추가</button><br/>

<!--    <ul>-->
<!--      <li v-for="(monster, index) in monsterLists" :key="index">-->
<!--        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}-->
<!--      </li>-->
<!--    </ul>-->
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "MonsterManager",
  data () {
    return {
      addMonsterLists: [],
    }
  },
  methods: {
    // findCurrentMonsterListMax () {
    //   return this.monsterLists.reduce(
    //       (a, b) => { console.log("a: " + a + ", b.id: " + b.id); return a > b.id ? a : b.id },
    //       0)
    // },
    ...mapActions(['requestAddMonster']),
    async addManyRandomMonster () {
      console.log("addManyRandomMonster()")
      await this.requestAddMonster();
      this.addMonsterLists = this.$store.state.addMonsterLists
    },
    // async addManyRandomMonster () {
    //   console.log("addManyRandomMonster()")
    //   await this.requestAddMonster()
    //   for (let i = 0; i < this.$store.state.monsterLists.length; i++) {
    //     this.monsterLists.push(this.$store.state.monsterLists[i])
    //   }
    // },
  }
}
</script>

<style scoped>
</style>