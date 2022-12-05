<template>
  <div>
    <p>캐릭터 상태 창 (Local Component)</p>
    <p>HP: {{ characterStatusValues.hp }} MP: {{ characterStatusValues.mp }} ATK: {{ characterStatusValues.atk }} Lv: {{ characterStatusValues.level }} 직업: {{ characterStatusValues.currentJob }}</p>
    <p>STR: {{ characterStatusValues.str }} INT: {{ characterStatusValues.intelligence }} DEX: {{ characterStatusValues.dex }} VIT: {{ characterStatusValues.vit }} DEF: {{ characterStatusValues.def }} MEN: {{ characterStatusValues.men }}</p>
    <p>경험치: {{ characterStatusValues.currentLevelBar }} / {{ characterStatusValues.totalLevelBar }}</p>
    <p>소지금: {{ characterStatusValues.money }}</p>
  </div>
</template>

<script>

import {mapActions, mapState} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {
    }
  },
  computed:{
    ...mapState([
        'characterStatusValues',
    ])
  },
  methods: {
    ...mapActions(['requestCharacterStatusFromSpring']),
  },
  async mounted() {
    await this.requestCharacterStatusFromSpring()
  },
}
</script>

<style scoped>
</style>