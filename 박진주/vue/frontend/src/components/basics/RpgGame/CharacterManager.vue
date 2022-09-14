<template>
<div>
  <p>캐릭터 상태 창 <button v-on:click="showCharacterData">내 캐릭터 정보 보기</button></p>
  <p>HP: {{characterStatus.hp}} MP: {{characterStatus.mp}} ATK: {{characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
  <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
  <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
  <p>소지금: {{ characterStatus.money }}</p>
</div>

</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "CharacterManager",

  data() {
    return {
      characterStatusList:[],
      characterStatus: {
        level: '',
        hp: '',
        mp: '',
        itemAtk: '',
        defaultAtk: '',
        atk: '',
        str: '',
        intelligence: '',
        dex: '',
        vit: '',
        def: '',
        men: '',
        totalLevelBar: '',
        currentLevelBar: '',
        money: '',
        currentJob: ''
      }
    }
  },
  methods: {
    ...mapActions(['requestCharacterFromSpring']),
    async showCharacterData() {
      await this.requestCharacterFromSpring()
      this.characterStatusList = this.$store.state.characterValue
      this.characterStatus.level= this.characterStatusList[0].level
      this.characterStatus.hp= this.characterStatusList[0].hp
      this.characterStatus.mp= this.characterStatusList[0].mp
      this.characterStatus.itemAtk= this.characterStatusList[0].itemAtk
      this.characterStatus.defaultAtk= this.characterStatusList[0].defaultAtk
      this.characterStatus.atk= this.characterStatusList[0].atk
      this.characterStatus.str= this.characterStatusList[0].str
      this.characterStatus.intelligence= this.characterStatusList[0].intelligence
      this.characterStatus.dex= this.characterStatusList[0].dex
      this.characterStatus.vit= this.characterStatusList[0].vit
      this.characterStatus.def= this.characterStatusList[0].def
      this.characterStatus.men= this.characterStatusList[0].men
      this.characterStatus.totalLevelBar= this.characterStatusList[0].totalLevelBar
      this.characterStatus.currentLevelBar= this.characterStatusList[0].currentLevelBar
      this.characterStatus.money= this.characterStatusList[0].money
      this.characterStatus.currentJob= this.characterStatusList[0].currentJob

    }

  }
}

</script>

<style scoped>

</style>