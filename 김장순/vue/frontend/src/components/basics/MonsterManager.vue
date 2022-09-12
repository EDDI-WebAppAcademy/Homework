<template>
  <div>

    <button @click="addManyRandomMonster">(Local Component)랜덤 몬스터 100마리 추가</button>
    <br/>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
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
      monsterLists: [],
    }
  },
  async mounted() {
    await this.requestDefaultMonsters
    this.monsterLists = this.$store.state.defaultMonsters

  },
  methods: {
    ...mapActions([
      'requestManyMonsters'
    ]),
    async addManyRandomMonster() {
      await this.requestManyMonsters()
      this.monsterLists = this.$store.state.manyMonsters
    },
    /*findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => {
            console.log("a: " + a + ", b.id: " + b.id);
            return a > b.id ? a : b.id
          },
          0)
    },*/
    /*addRandomMonster() {
      let max = this.findCurrentMonsterListMax()
      // ex) 20개라면 0 ~ 19.xxx 까지인데 floor 버림이니까 0 ~ 19까지
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)
      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },*/
  }
}
</script>

<style scoped>
</style>