<template>
  <div>
    <h3>(Local)캐릭터 상태 창</h3>
    <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }}
      Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }}
      VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
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
      characterStatus: {
        level: 1,
        hp: 50,
        mp: 30,
        itemAtk: 0,
        defaultAtk: 10,
        atk: 10,
        str: 10,
        intelligence: 10,
        dex: 10,
        vit: 10,
        def: 10,
        men: 0,
        totalLevelBar: 10,
        currentLevelBar: 0,
        money: 0,
        currentJob: '모험가'
      },
    }
  },
  methods: {
    ...mapActions(['requestCharacterStatus'])
  }
}
</script>

<style scoped>

</style>