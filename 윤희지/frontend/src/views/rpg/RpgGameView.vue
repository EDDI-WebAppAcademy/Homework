<template>
  <div>
    <market-manager/>
    <inventory-manager/>
    <experience-manager/>
    <character-manager/>
    <monster-manager/>
  </div>
</template>

<script>
import MarketManager from "@/components/basics/MarketManager";
import InventoryManager from "@/components/basics/InventoryManager";
import ExperienceManager from "@/components/basics/ExperienceManager";
import CharacterManager from "@/components/basics/CharacterManager";
import MonsterManager from "@/components/basics/MonsterManager";

export default {
  name: "RpgGameView",
  components: {
    'monster-manager': MonsterManager,
    'character-manager': CharacterManager,
    'experience-manager': ExperienceManager,
    'inventory-manager': InventoryManager,
    'market-manager': MarketManager
  },
  methods: {

  }
}
</script>

<style scoped>

</style>