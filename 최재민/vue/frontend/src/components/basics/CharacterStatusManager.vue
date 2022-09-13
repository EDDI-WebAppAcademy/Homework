<template>
  <div>
    <p>캐릭터 상태창</p>
    <p>HP: {{ characterStatus[0].hp }} MP: {{ characterStatus[0].mp }} ATK: {{ characterStatus[0].atk }} Lv: {{ characterStatus[0].level }} 직업: {{ characterStatus[0].currentJob }}</p>
    <p>STR: {{ characterStatus[0].str }} INT: {{ characterStatus[0].intelligence }} DEX: {{ characterStatus[0].dex }} VIT: {{ characterStatus[0].vit }} DEF: {{ characterStatus[0].def }} MEN: {{ characterStatus[0].men }}</p>
    <p>경험치: {{ characterStatus[0].currentLevelBar }} / {{ characterStatus[0].totalLevelBar }}</p>
    <p>소지금: {{ characterStatus[0].money }}</p>
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "CharacterStatusManager",
  data(){
    return{
      characterStatus: [],
    }
  },
  methods:{
    ...mapActions(['requestCharacterDefaultStatus'])
    },
  async mounted() {
    await this.requestCharacterDefaultStatus()
    this.characterStatus = this.$store.state.CharacterStatus
  },
  // async beforeUpdate() {
  //   await this.requestCharacterDefaultStatus()
  //   this.characterStatus = this.$store.state.CharacterStatus
  // }
}
</script>

<style scoped>

</style>