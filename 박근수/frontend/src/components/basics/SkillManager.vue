<template>
  <div>
    <button v-on:click="bulletTime()">Time Damage(Local Component)</button><br/>
  </div>
</template>

<script>

import {mapActions} from "vuex";
import MonsterManager from "@/components/basics/MonsterManager";

export default {
  name: "SkillManager",
  data(){
    return{
    }
  },
  methods: {
    ...mapActions(['timeDamage']),
    async damDamage(){
      await this.timeDamage()
      MonsterManager.monsterLists = this.$store.state.damagedMonstersList
    }
  }
}
</script>

<style scoped>

</style>