<template>
  <div>
    <button v-on:click="addHundredRandomMonster()">(Local Component)랜덤 몬스터 100마리 추가</button><br/>
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
  name: "SkillManager",
  data () {
    return {
      monsterLists: [
      ],
    }
  },
  methods: {
    ...mapActions([
        'requestDefaultMonsterList',
        'requestHundredMonsterLists'
    ]),
    async addHundredRandomMonster () {
      await this.requestHundredMonsterLists()
      this.monsterLists = this.$store.state.hundredMonsterLIst
    },
  },
  async mounted() {
    this.monsterLists = []
    await this.requestDefaultMonsterList()
    this.monsterLists = this.$store.state.defaultMonsterList
  }
}
</script>

<style scoped>
</style>