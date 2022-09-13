<template>
  <div>

    <market-manager/>
    <exp-manager/>
    <character-manager/>
    <monster-manager/>

  </div>
</template>

<script>
import MonsterManager from "@/components/basic/MonsterManager";
import CharacterManager from "@/components/basic/CharacterManager";
import MarketManager from "@/components/basic/MarketManager";
import ExpManager from "@/components/basic/ExpManager";

export default {
  name: "RpgGameView",
  components: {
    'monster-manager': MonsterManager,
    'character-manager': CharacterManager,
    'market-manager': MarketManager,
    'exp-manager': ExpManager
  },
  methods: {
  },
  beforeUpdate() {
    CharacterManager.methods.viewCharacterInventory()
  }
}
</script>

<style scoped>

</style>