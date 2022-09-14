<template>
  <div>
    <button v-on:click="bulletTime()">Bullet Time(광역기)(Local Component)</button><br/>
  </div>
</template>

<script>
import {mapActions} from "vuex";
import MonsterManager from "@/components/basics/MonsterManager";

export default {
  name: "SkillsManager",
  data(){
    return{
    }
  },
  methods: {
    ...mapActions(['bulletTimeDamage']),
    async bulletTime(){
      await this.bulletTimeDamage()
      MonsterManager.monsterLists = this.$store.state.damagedMonstersList
    }
    // bulletTime(){
    //   console.log("쌍권총 난사")
    //   for (let i = 0 ; i < MonsterManager.data().monsterLists.length; i++){
    //     MonsterManager.data().monsterLists[i].hp -= 30 * CharacterStatus.data().characterStatus.atk
    //   }
    // }
  }
}
</script>

<style scoped>

</style>