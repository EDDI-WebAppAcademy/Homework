<template>
  <div>
    <p>캐릭터 상태 창 (Local Component)</p>
    <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ characterStatus.money }}</p>
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