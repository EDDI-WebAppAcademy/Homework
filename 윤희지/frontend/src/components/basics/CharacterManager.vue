<template>
  <div>
    <button @click="showCharacterStatus">캐릭터 상태 창</button>
    <p v-if="characterStatusShow">HP: {{ characterStatus.currentHp }} / {{ characterStatus.hp }} MP: {{ characterStatus.currentMp }} / {{ characterStatus.mp }} </p>
    <p v-if="characterStatusShow">ATK: {{ characterStatus.atk + characterStatus.defaultAtk + characterStatus.itemAtk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p v-if="characterStatusShow">STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }}
      VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p v-if="characterStatusShow">경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p v-if="characterStatusShow">소지금: {{ characterStatus.money }}</p>
  </div>

</template>

<script>

import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {
      characterStatusShow: false,
      characterStatus: {}
    }
  },
  methods: {
    ...mapActions(['requestCharacterStatusData']),
    async showCharacterStatus () {
      await this.requestCharacterStatusData()
      this.characterStatus = this.$store.state.characterStatusData
      this.characterStatusOnOff()
    },
    characterStatusOnOff () {
      this.characterStatusShow = !this.characterStatusShow
    }

  },
  beforeUpdate() {

  }

}
</script>

<style scoped>

</style>