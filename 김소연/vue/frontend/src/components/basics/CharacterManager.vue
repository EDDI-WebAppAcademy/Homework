<template>
  <div>
    <p>캐릭터 상태 창 (Local Component)</p>
    <p>HP: {{ this.characterStatus.hp }} MP: {{ this.characterStatus.mp }} ATK: {{ this.characterStatus.atk }} Lv: {{ this.characterStatus.level }} 직업: {{ this.characterStatus.currentJob }}</p>
    <p>STR: {{ this.characterStatus.str }} INT: {{ this.characterStatus.intelligence }} DEX: {{ this.characterStatus.dex }} VIT: {{ this.characterStatus.vit }} DEF: {{ this.characterStatus.def }} MEN: {{ this.characterStatus.men }}</p>
    <p>경험치: {{ this.characterStatus.currentLevelBar }} / {{ this.characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ this.characterStatus.money }}</p>
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {
      characterStatus: {}
    }
  },
  mounted() {
    this.viewCharacterStatus()
  },
  methods: {
    ...mapActions(['requestCharacterStatus']),
    async viewCharacterStatus () {
      await this.requestCharacterStatus()
      this.characterStatus = this.$store.state.characterStatus
    }
  }
}
</script>

<style scoped>
</style>