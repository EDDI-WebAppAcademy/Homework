<template>
  <div>
    <p>캐릭터 상태창</p>
    <p>HP: {{ CharacterStatus.hp }} MP: {{ CharacterStatus.mp }} ATK: {{ CharacterStatus.atk }} Lv: {{ CharacterStatus.level }} 직업: {{ CharacterStatus.currentJob }}</p>
    <p>STR: {{ CharacterStatus.str }} INT: {{ CharacterStatus.intelligence }} DEX: {{ CharacterStatus.dex }} VIT: {{ CharacterStatus.vit }} DEF: {{ CharacterStatus.def }} MEN: {{ CharacterStatus.men }}</p>
    <p>경험치: {{ CharacterStatus.currentLevelBar }} / {{ CharacterStatus.totalLevelBar }}</p>
    <p>소지금: {{ CharacterStatus.money }}</p>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "CharacterStatusManager",
  data(){
    return{
    }
  },
  computed:{
    ...mapState([
      'CharacterStatus'
    ])
  },
  methods:{
    ...mapActions([
        'requestCharacterDefaultStatus',
    ])
    },
  async mounted() {
    await this.requestCharacterDefaultStatus()
  },
  // async beforeUpdate() {
  //
  //   await this.requestCharacterDefaultStatus()
  //   this.characterStatus = this.$store.state.CharacterStatus
  //
  //   if (this.characterStatus.level == 99) { return }
  //
  // }
  }
</script>

<style scoped>

</style>